package com.wl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.wl"})
@SpringBootApplication
public class WlApplication {
    public static void main(String[] args) {
        SpringApplication.run(WlApplication.class, args);
    }
}