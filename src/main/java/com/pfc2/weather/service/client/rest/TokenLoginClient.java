package com.pfc2.weather.service.client.rest;

import com.pfc2.weather.service.dto.TokenRequest;
import com.pfc2.weather.service.dto.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "tokenLoginClient", url = "${services.auth}")
public interface TokenLoginClient {
    @PostMapping("/token")
    TokenResponse generateJwtToken(@RequestBody TokenRequest body);
}
