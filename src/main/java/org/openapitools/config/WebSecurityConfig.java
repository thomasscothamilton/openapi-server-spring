package org.openapitools.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {

    private static final String API_KEY_HEADER = "X-API-KEY";

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        AuthenticationWebFilter apiKeyFilter = new AuthenticationWebFilter(apiKeyAuthManager());
        apiKeyFilter.setSecurityContextRepository(NoOpServerSecurityContextRepository.getInstance());
        apiKeyFilter.setServerAuthenticationConverter(this::convertApiKey);

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance()) // stateless
                .addFilterAt(apiKeyFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .authorizeExchange(ex -> ex
                        .pathMatchers("/health/**").permitAll()
                        .anyExchange().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    private Mono<Authentication> convertApiKey(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst(API_KEY_HEADER))
                .map(ApiKeyAuthenticationToken::new);
    }

    @Bean
    public ReactiveAuthenticationManager apiKeyAuthManager() {

        final String expected = "EXPECTED_API_KEY";

        return authentication -> {
            String key = (String) authentication.getCredentials();

            if (key == null || key.isBlank()) {
                return Mono.empty();
            }

            if (expected.equals(key)) {
                var authed = new ApiKeyAuthenticationToken(
                        key,
                        List.of(new SimpleGrantedAuthority("ROLE_API_KEY"))
                );
                authed.setAuthenticated(true);
                return Mono.just(authed);
            }

            return Mono.error(new BadCredentialsException("Invalid API key"));
        };
    }
}