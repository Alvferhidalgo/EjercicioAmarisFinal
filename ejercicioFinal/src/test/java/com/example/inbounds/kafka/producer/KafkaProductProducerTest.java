package com.example.inbounds.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class KafkaProductProducerTest {

    String STRING_VALUE = "1";

    @Mock
    KafkaTemplate<String,String> kafkaTemplate;

    @Mock
    ObjectMapper mapper;

    @InjectMocks
    KafkaProductProducer producer;

    @Test
    void sendStringTest(){
        //when
        producer.sendString(STRING_VALUE);
        //then
        Mockito.verify(kafkaTemplate).sendDefault(Mockito.any());
    }
}