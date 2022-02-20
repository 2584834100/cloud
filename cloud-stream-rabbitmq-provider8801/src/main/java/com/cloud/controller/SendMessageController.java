package com.cloud.controller;

import com.cloud.services.IMessageProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @PostMapping("/sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
