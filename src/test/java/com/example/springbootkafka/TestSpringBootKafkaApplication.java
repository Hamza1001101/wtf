package com.example.springbootkafka;

import org.springframework.boot.SpringApplication;

public class TestSpringBootKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringBootKafkaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
