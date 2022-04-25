package com.example.kafkaProducerExercise.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class ConsumerTest {

    String STRING_VALUE = "value";

    @Mock
    ConsumerRecord<String,String> consumerRecord;

    @InjectMocks
    Consumer consumer;

    @Test
    void processProductTest() throws JsonProcessingException {
        //given
        when(consumerRecord.value()).thenReturn(STRING_VALUE);
        //when
        consumer.processProduct(consumerRecord);
        //then
        Assertions.assertNotNull(consumerRecord);
    }
}