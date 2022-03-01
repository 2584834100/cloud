package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider9003Controller {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getPort")
    public String getPort() {
        int a = 1/0;
        return port;
    }
}