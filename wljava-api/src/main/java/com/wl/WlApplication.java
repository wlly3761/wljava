package com.wl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ComponentScan(basePackages = {"com.wl"})
@SpringBootApplication
public class WlApplication {
    public static void main(String[] args) {
        SpringApplication.run(WlApplication.class, args);
    }
}