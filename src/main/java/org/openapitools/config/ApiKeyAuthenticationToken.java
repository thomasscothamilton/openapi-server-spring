package org.openapitools.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

/**
 * Simple Authentication implementation that carries just the raw API key.
 */
public class ApiKeyAuthenticationToken extends AbstractAuthenticationToken {

    private final String apiKey;

    public ApiKeyAuthenticationToken(String apiKey) {
        this(apiKey, Collections.emptyList());
    }

    public ApiKeyAuthenticationToken(String apiKey,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.apiKey = apiKey;
        setAuthenticated(false);
    }

    @Override public Object getCredentials() { return apiKey; }
    @Override public Object getPrincipal()   { return apiKey; }
}
