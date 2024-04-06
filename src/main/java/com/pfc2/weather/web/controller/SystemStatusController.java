package com.pfc2.weather.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/status")
public class SystemStatusController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void checkSystemStatus() {

    }
}
