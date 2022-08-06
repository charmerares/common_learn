package com.iris.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: royalvald
 * @Date: 2022/8/5 23:02
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return new Date().toString();
    }
}
