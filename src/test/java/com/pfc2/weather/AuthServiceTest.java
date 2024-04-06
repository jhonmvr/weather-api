package com.pfc2.weather;

import com.pfc2.weather.service.AuthService;
import com.pfc2.weather.service.client.rest.HttpClientsFactory;
import com.pfc2.weather.service.client.rest.TokenLoginClient;
import com.pfc2.weather.service.dto.TokenRequest;
import com.pfc2.weather.service.dto.TokenResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @InjectMocks
    private AuthService authService;
    @Mock
    private HttpClientsFactory clientsFactory;
    @Mock
    private TokenLoginClient tokenLoginClient;
    private TokenRequest tokenRequest;
    private TokenResponse tokenResponse;

    @BeforeEach
    void setUp() {
        tokenResponse = new TokenResponse("token", 1l, "Bearer");
        tokenRequest = new TokenRequest("clientId", "clientSecret", "audience", "grantType");
    }

    @Test
    void generateToken() {
        when(clientsFactory.getTokenLoginClient()).thenReturn(tokenLoginClient);
        when(clientsFactory.getTokenLoginClient().generateJwtToken(any())).thenReturn(tokenResponse);
        var result = authService.generateToken();
        assertEquals(result.getTokenType(), tokenResponse.getTokenType());
    }
}
