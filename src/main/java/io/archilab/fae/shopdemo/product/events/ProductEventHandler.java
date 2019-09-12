package io.archilab.fae.shopdemo.product.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.archilab.fae.shopdemo.kafka.KafkaMessageProducer;
import io.archilab.fae.shopdemo.product.Product;


@Component
public class ProductEventHandler {

  private final String topic;
  private final KafkaMessageProducer kafkaMessageProducer;

  @Autowired
  public ProductEventHandler(
      @Value("${product.topic}") final String topic,
      final KafkaMessageProducer kafkaMessageProducer) {
    this.kafkaMessageProducer = kafkaMessageProducer;
    this.topic = topic;
  }

  @PostPersist
  public void handleProductCreate(Product product)
      throws JsonProcessingException {
    this.kafkaMessageProducer.send(this.topic,
        buildProductDomainEvent(product, ProductEventType.CREATED));
  }

  @PostUpdate
  public void handleProductSave(Product product)
      throws JsonProcessingException {
    this.kafkaMessageProducer.send(this.topic,
        buildProductDomainEvent(product, ProductEventType.UPDATED));
  }

  @PostRemove
  public void handleProductDelete(Product product)
      throws JsonProcessingException {
    this.kafkaMessageProducer.send(this.topic,
        buildProductDomainEvent(product, ProductEventType.DELETED));
  }

  private ProductDomainEvent buildProductDomainEvent(Product product, ProductEventType eventType) {
    return new ProductDomainEvent(product.getId(), eventType);
  }
}
