package com.wl.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Test Controller")
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public String test() {
        return "Hello World!";
    }
}
