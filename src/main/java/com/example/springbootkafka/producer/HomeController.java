package com.example.springbootkafka.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wtf")
public class HomeController {

    @GetMapping
    public String helloword() {
        return "hello world";
    }
}
