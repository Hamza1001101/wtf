package com.example.springbootkafka.producer;



import java.math.BigDecimal;

public record Product(Long id, String code, String name, BigDecimal price) {
}
