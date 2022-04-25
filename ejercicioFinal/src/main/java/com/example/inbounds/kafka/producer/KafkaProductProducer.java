package com.example.inbounds.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Data
public class KafkaProductProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  private final ObjectMapper mapper;

  public void sendString(final String s) {

    this.kafkaTemplate.setDefaultTopic("productTopic");
    this.kafkaTemplate.sendDefault(s);
  }
}
