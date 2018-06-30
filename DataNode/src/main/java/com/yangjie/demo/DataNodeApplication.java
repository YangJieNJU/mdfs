package com.yangjie.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class DataNodeApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DataNodeApplication.class)
                .web(true).run(args);
    }
}
