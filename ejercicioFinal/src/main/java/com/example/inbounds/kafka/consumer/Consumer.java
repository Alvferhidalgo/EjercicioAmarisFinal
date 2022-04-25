package com.example.inbounds.kafka.consumer;

import com.example.domain.services.PriceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Consumer {

  private final Logger log = LoggerFactory.getLogger(Consumer.class);
  private final ObjectMapper mapper;
  private final PriceService service;

  @KafkaListener(topics = { "exercisetopic" })
  public void processProduct(final ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
    String value = consumerRecord.value();
    ProductRequest productRequest = mapper.readValue(value, ProductRequest.class);
    service.updateFromRequest(productRequest.getProductId(), productRequest.getPriceListId(), productRequest.getPrice());
    log.info(value);
    log.info(productRequest.toString());
  }
}
