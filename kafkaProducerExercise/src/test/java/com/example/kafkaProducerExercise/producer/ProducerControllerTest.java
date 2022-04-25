package com.example.kafkaProducerExercise.producer;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerControllerTest {

    String STRING_VALUE = "value";

    @Mock
    Producer producer;

    @InjectMocks
    ProducerController prouducerController;

    @Test
    void sendDataTest(){
        //when
        prouducerController.sendData(STRING_VALUE);
        //then
        Mockito.verify(producer).sendString(STRING_VALUE);
    }


}