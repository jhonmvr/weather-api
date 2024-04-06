package com.pfc2.weather.service;

import com.pfc2.weather.service.client.rest.HttpClientsFactory;
import com.pfc2.weather.service.dto.TokenRequest;
import com.pfc2.weather.service.dto.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final HttpClientsFactory clientsFactory;
    private final TokenRequest tokenRequest;

    public AuthService(HttpClientsFactory clientsFactory,
                       @Value("${app.secrets.oauth.client-id}") String clientId,
                       @Value("${app.secrets.oauth.client-secret}") String clientSecret,
                       @Value("${app.secrets.oauth.audience}") String audience,
                       @Value("${app.secrets.oauth.grant-type}") String grantType) {
        this.clientsFactory = clientsFactory;
        this.tokenRequest = new TokenRequest(clientId, clientSecret, audience, grantType);
    }


    public TokenResponse generateToken() {
        return clientsFactory.getTokenLoginClient().generateJwtToken(tokenRequest);
    }
}
