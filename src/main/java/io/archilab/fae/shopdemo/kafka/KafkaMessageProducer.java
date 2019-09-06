package io.archilab.fae.shopdemo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.archilab.fae.shopdemo.core.DomainEvent;


@Component
public class KafkaMessageProducer {

  private final Logger logger = LoggerFactory.getLogger(KafkaMessageProducer.class);
  private final KafkaTemplate<String, String> template;
  private final ObjectMapper objectMapper;

  @Autowired
  public KafkaMessageProducer(
      final KafkaTemplate<String, String> template,
      final ObjectMapper objectMapper) {
    this.template = template;
    this.objectMapper = objectMapper;

  }

  public void send(final String topic, final DomainEvent commentEvent)
      throws JsonProcessingException {

    ListenableFuture<SendResult<String, String>> future = this.template
        .send(topic, commentEvent.getEventID().toString(),
            this.objectMapper.writeValueAsString(commentEvent));

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

      @Override
      public void onSuccess(SendResult<String, String> result) {
        KafkaMessageProducer.this.logger
            .info("Successfully send message with key: {}", result.getProducerRecord().key());
      }

      @Override
      public void onFailure(Throwable ex) {
        KafkaMessageProducer.this.logger.error("Error while sending message with message:");
        KafkaMessageProducer.this.logger.error(ex.getMessage());
      }

    });
  }
}
