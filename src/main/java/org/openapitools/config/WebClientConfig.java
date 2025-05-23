package org.openapitools.config;

import org.openapitools.client.DocumentClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthentication;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(@Value("${document.service.base-url}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(propagateAuthHeaders())
                .build();
    }

    private ExchangeFilterFunction propagateAuthHeaders() {

        return ExchangeFilterFunction.ofRequestProcessor(originalRequest ->

                ReactiveSecurityContextHolder.getContext()
                        .map(ctx -> ctx.getAuthentication())
                        .flatMap(auth -> Mono.just(mutateRequestWithAuth(originalRequest, auth)))
                        .switchIfEmpty(Mono.just(originalRequest))
        );
    }

    private ClientRequest mutateRequestWithAuth(ClientRequest original, Authentication auth) {

        if (auth == null) {
            return original;                                   // unauthenticated
        }
        ClientRequest.Builder builder = ClientRequest.from(original);

        /* Bearer token */
        if (auth instanceof BearerTokenAuthentication bearer) {
            builder.header(HttpHeaders.AUTHORIZATION,
                    "Bearer " + bearer.getToken().getTokenValue());
        }
        /* API-key token (custom class) */
        else if (auth instanceof ApiKeyAuthenticationToken apiKey) {
            builder.header("X-API-KEY", apiKey.getCredentials().toString());
        }
        return builder.build();
    }

    @Bean
    public DocumentClient documentClient(WebClient webClient) {
        return new DocumentClient(webClient);
    }
}
