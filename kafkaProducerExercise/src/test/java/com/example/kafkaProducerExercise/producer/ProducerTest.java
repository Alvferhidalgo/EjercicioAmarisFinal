package com.example.kafkaProducerExercise.producer;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class ProducerTest {

    String STRING_VALUE = "value";

    @Mock
    KafkaTemplate kafkaTemplate;

    @InjectMocks
    Producer producer;

    @Test
    void sendStringTest(){
        //when
        producer.sendString(STRING_VALUE);
        //then
        Mockito.verify(kafkaTemplate).sendDefault(Mockito.any());
    }

}