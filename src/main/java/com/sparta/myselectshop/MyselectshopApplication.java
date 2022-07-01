package com.sparta.myselectshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication // Hey, Java! I will use Spring Boot Framework!
@EnableJpaAuditing // Enable TimeStamped

public class MyselectshopApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyselectshopApplication.class, args);
    }

}
