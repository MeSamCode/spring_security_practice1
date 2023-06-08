package com.mesamcode.spring_security_practice1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sec")
public class DemoController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring security world!";
    }

}
