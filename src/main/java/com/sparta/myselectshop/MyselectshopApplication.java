package com.sparta.myselectshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication // Hey, Java! I will use Spring Boot Framework!
@EnableJpaAuditing // Enable TimeStamped
@EnableScheduling // Scheduling JPA Activate!

public class MyselectshopApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyselectshopApplication.class, args);
    }

}
