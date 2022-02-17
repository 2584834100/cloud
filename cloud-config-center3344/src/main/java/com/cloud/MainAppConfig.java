package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MainAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(MainAppConfig.class, args);
    }
}
