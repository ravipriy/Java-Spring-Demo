package com.springdemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// if we want to not auto configure means not create bean automatically then we can use exclude
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })


@SpringBootApplication
public class SpringdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }
}

