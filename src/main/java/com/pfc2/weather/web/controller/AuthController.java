package com.pfc2.weather.web.controller;

import com.pfc2.weather.service.AuthService;
import com.pfc2.weather.service.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name = "Login", description = "APi to generate a token in oauth0.")
public class AuthController {
    private final AuthService authService;

    @Operation(summary = "Generate a token to consume API")
    @GetMapping("/token")
    ResponseEntity<TokenResponse> getJwtToken() {
        return ResponseEntity.ok(authService.generateToken());
    }
}
