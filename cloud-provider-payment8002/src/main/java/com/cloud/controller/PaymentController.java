package com.cloud.controller;

import com.cloud.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getPort")
    public CommonResult getPort()
    {
        return new CommonResult(200,"成功",port);
    }

}
