package com.example.inbounds.kafka.consumer;

import com.example.domain.services.PriceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerTest {

    ProductRequest productRequest = new ProductRequest("1", 1, 1D);
    String STRING_VALUE = "1";

    @Mock
    PriceService service;

    @Mock
    ConsumerRecord<String, String> consumerRecord;

    @Mock
    ObjectMapper mapper;

    @InjectMocks
    Consumer consumer;

    @Test
    void processProductTest() throws JsonProcessingException {
        //given
        Mockito.when(consumerRecord.value()).thenReturn(STRING_VALUE);
        Mockito.when(mapper.readValue(STRING_VALUE, ProductRequest.class)).thenReturn(productRequest);
        //when
        consumer.processProduct(consumerRecord);
        //then
        Mockito.verify(service).updateFromRequest("1", 1, 1D);
    }

}