package com.example.kafkaProducerExercise.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    @KafkaListener(topics = {"productTopic"})
    public void processProduct(final ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        String value = consumerRecord.value();
        log.info(value);
    }
}