package com.example.skateboardparkapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SkateboardParkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkateboardParkApplication.class, args);
    }

}
