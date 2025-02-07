package com.example.springbootkafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductService {

    final JdbcClient client;

    final KafkaTemplate<String, Product> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(getClass());


    public ProductService(JdbcClient client, KafkaTemplate<String, Product> kafkaTemplate) {
        this.client = client;
        this.kafkaTemplate = kafkaTemplate;
    }


    public List<Product> findAll() {
        return client.sql("select *from products")
                .query(Product.class)
                .list();
    }

    public void save(Product product) {
        int update = client.sql("insert into products(code, name, price) VALUES (?,?,?)")
                .param(product.code())
                .param(product.name())
                .param(product.price())
                .update();
        assert update != 0;
        logger.info("successfully updated products");
    }

    public void saveToKafka(Product product) {
        kafkaTemplate.send("products", product)
                .whenComplete((res, exp) -> {
                    if (exp != null) {
                        logger.info("Something got fucked up {}", exp.getMessage());
                    } else logger.info("successfully sent message with id {}", product.id());
                });
    }
}
