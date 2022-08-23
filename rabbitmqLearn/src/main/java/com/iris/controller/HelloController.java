package com.iris.controller;

import com.iris.service.rabbitmq.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: royalvald
 * @Date: 2022/8/5 23:02
 */
@RestController
public class HelloController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/hello")
    public String hello(){
        return new Date().toString();
    }

    @GetMapping("/test1")
    public String testRabbitmq(){
        providerService.testProvider();
        return "send success";
    }
}
