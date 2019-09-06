package io.archilab.fae.shopdemo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class ProductEventConsumer {

  private final ObjectMapper objectMapper;

  @Autowired
  public ProductEventConsumer(
      final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @KafkaListener(topics = "${product.topic}", groupId = "${spring.kafka.group-id}")
  public void listen(String message) throws IOException {
    ProductDomainEvent productDomainEvent = this.objectMapper
        .readValue(message, ProductDomainEvent.class);

    System.out.println("*****************************");
    System.out.println("Product " + productDomainEvent.getEventType());
    System.out.println("*****************************");
  }
}
