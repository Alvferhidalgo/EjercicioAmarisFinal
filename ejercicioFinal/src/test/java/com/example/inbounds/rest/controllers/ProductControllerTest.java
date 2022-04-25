package com.example.inbounds.rest.controllers;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Product;
import com.example.inbounds.kafka.producer.KafkaProductProducer;
import com.example.inbounds.mappers.InboundsProductMapper;
import com.example.inbounds.ports.in.ProductInputPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ProductControllerTest {

    LocalDateTime DATE = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
    BrandDto brandDto = new BrandDto();
    ProductDto productDto = new ProductDto("1", null, DATE, DATE, "1", 1L, DATE);
    ProductDto productDtoNull = new ProductDto();
    Product product = new Product("1", null, DATE, DATE, "1", 1L, DATE);;
    List<Product> products = List.of(product);

    ResponseEntity<ProductDto> expectedNoContentResponse = ResponseEntity.noContent().build();
    ResponseEntity<ProductDto> expectedoKResponse = ResponseEntity.ok(productDto);
    ResponseEntity<ProductDto> expectedBadRequest = ResponseEntity.badRequest().build();

    @Mock
    ProductInputPort productInputPort;

    @Mock
    KafkaProductProducer producer;

    @Mock
    InboundsProductMapper productMapper;

    @InjectMocks
    ProductController controller;

    @Test
    void findAllProductsTest() {
        //given
        Mockito.when(productMapper.mapResponse(Mockito.any())).thenReturn(productDto);
        Mockito.when(productInputPort.findAll()).thenReturn(products);
        //when
        List<ProductDto> dtos = controller.findAllProducts();
        //then
        Assertions.assertEquals(1, dtos.size());
    }

    @Test
    void saveNotNullTestTest() {
        //when
        ResponseEntity<ProductDto> response = controller.save(productDto);
        //then
        Mockito.verify(productMapper, Mockito.never()).mapResponse(Mockito.any());
        Assertions.assertEquals(expectedBadRequest, response);
    }

    @Test
    void saveTest() {
        //given
        Mockito.when(productMapper.mapResponse(Mockito.any())).thenReturn(productDto);
        //when
        ResponseEntity<ProductDto> response = controller.save(productDtoNull);
        //then
        Mockito.verify(productMapper).mapResponse(Mockito.any());
        Assertions.assertEquals(expectedoKResponse, response);
    }

    @Test
    void updateNullTest() {
        //when
        ResponseEntity<ProductDto> response = controller.update(productDtoNull);
        //then
        Mockito.verify(productMapper, Mockito.never()).mapResponse(Mockito.any());
        Assertions.assertEquals(expectedBadRequest, response);
    }

    @Test
    void updateTest() {
        //given
        Mockito.when(productMapper.mapResponse(Mockito.any())).thenReturn(productDto);
        //when
        ResponseEntity<ProductDto> response = controller.update(productDto);
        //then
        Mockito.verify(productMapper).mapResponse(Mockito.any());
        Assertions.assertEquals(expectedoKResponse, response);
    }

    @Test
    void deleteByIdTest() {
        //when
        ResponseEntity<ProductDto> response = controller.deleteById("1");
        //then
        Assertions.assertEquals(expectedNoContentResponse, response);
    }
}