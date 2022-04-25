package com.example.inbounds.rest.controllers;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import com.example.inbounds.mappers.InboundsPriceMapper;
import com.example.inbounds.ports.in.PriceInputPort;
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
class PriceControllerTest {

    LocalDateTime DATE = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
    BrandDto brandDto = new BrandDto();
    ProductDto productDto = new ProductDto();
    PriceDto priceDto = new PriceDto("1", brandDto, productDto, DATE, DATE, 1, 1, 1D, "EUR");
    PriceDto priceDtoNull = new PriceDto(null, brandDto, productDto, DATE, DATE, 1, 1, 1D, "EUR");
    Brand brand = new Brand("1","Zara",null);
    Product product = new Product("1",null,DATE,DATE,"1",1L,DATE);
    Price price = new Price("1", brand, product, DATE, DATE, 1, 1, 1D, "EUR");
    List<Price> prices = List.of(price);


    ResponseEntity<PriceDto> expectedNoContentResponse = ResponseEntity.noContent().build();
    ResponseEntity<PriceDto> expectedoKResponse = ResponseEntity.ok(priceDto);
    ResponseEntity<PriceDto> expectedBadRequest = ResponseEntity.badRequest().build();

    @Mock
    PriceInputPort priceInputPort;

    @Mock
    InboundsPriceMapper priceMapper;

    @Mock
    ResponseEntity responseEntity;

    @InjectMocks
    PriceController controller;

    @Test
    void findAllPricesTest() {
        //given
        Mockito.when(priceMapper.mapResponse(Mockito.any())).thenReturn(priceDto);
        Mockito.when(priceInputPort.findAll()).thenReturn(prices);
        //when
        List<PriceDto> dtos = controller.findAllPrices();
        //then
        Assertions.assertEquals(1,dtos.size());
    }

    @Test
    void saveNotNullTest() {
        //when
        ResponseEntity<PriceDto> response = controller.save(priceDto);
        //then
        Mockito.verify(priceMapper,Mockito.never()).mapResponse(Mockito.any());
        Assertions.assertEquals(expectedBadRequest,response);
    }

    @Test
    void saveTest(){
        //given
        Mockito.when(priceMapper.mapResponse(Mockito.any())).thenReturn(priceDto);
        //when
        ResponseEntity<PriceDto> response = controller.save(priceDtoNull);
        //then
        Mockito.verify(priceMapper).mapResponse(Mockito.any());
        Assertions.assertEquals(expectedoKResponse,response);
    }

    @Test
    void updateNullTest() {
        //when
        ResponseEntity<PriceDto> response = controller.update(priceDtoNull);
        //then
        Mockito.verify(priceMapper,Mockito.never()).mapResponse(Mockito.any());
        Assertions.assertEquals(expectedBadRequest,response);
    }

    @Test
    void updateTest() {
        //given
        Mockito.when(priceMapper.mapResponse(Mockito.any())).thenReturn(priceDto);
        //when
        ResponseEntity<PriceDto> response = controller.update(priceDto);
        //then
        Mockito.verify(priceMapper).mapResponse(Mockito.any());
        Assertions.assertEquals(expectedoKResponse,response);
    }

    @Test
    void deleteByIdTest() {
        //when
        ResponseEntity<PriceDto> response = controller.deleteById("1");
        //then
        Assertions.assertEquals(expectedNoContentResponse,response);
    }

    @Test
    void findByDateProductBrand() {
        //given
        Mockito.when(priceMapper.mapResponse(Mockito.any())).thenReturn(priceDto);
        //when
        List<PriceDto> dtos = controller.findByDateProductBrand("1","1","1");
        //then
        Assertions.assertEquals(0,dtos.size());
    }
}