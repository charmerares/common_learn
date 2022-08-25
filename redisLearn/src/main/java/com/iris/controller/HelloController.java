package com.iris.controller;

import com.iris.service.ConsumerService;
import com.iris.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: royalvald
 * @Date: 2022/8/25 20:54
 */
@RestController
public class HelloController {
    @Autowired
    private ConsumerService consumerService;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/test1")
    public String test1(){
        return consumerService.testGet("hello");
    }

    @GetMapping("/test2")
    public String test2(){
        return providerService.testSet("hello","hello world");
    }
}
