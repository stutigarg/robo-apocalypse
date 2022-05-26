package com.ioco.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IocoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocoApplication.class, args);
    }

}
