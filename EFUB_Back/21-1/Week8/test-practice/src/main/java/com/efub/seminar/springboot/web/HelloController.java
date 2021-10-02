package com.efub.seminar.springboot.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}