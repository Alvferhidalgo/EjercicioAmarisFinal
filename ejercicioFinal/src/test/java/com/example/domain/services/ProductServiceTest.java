package com.example.domain.services;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Product;
import com.example.inbounds.mappers.InboundsProductMapper;
import com.example.outbounds.ports.ProductOutputPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ProductServiceTest {

    LocalDateTime DATE = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
    Product product = new Product("1",null,DATE,DATE,"1",1L,DATE);
    BrandDto brandDto = new BrandDto("1","Zara",null);
    ProductDto productDto = new ProductDto("1",null,DATE,DATE,"1",1L,DATE);
    PriceDto priceDto = new PriceDto("1", brandDto, productDto, DATE, DATE, 1, 1, 1D, "EUR");
    List<ProductDto> productsDto = List.of(productDto);

    @Mock
    ProductOutputPort productOutputPort;

    @Mock
    InboundsProductMapper mapper;

    @InjectMocks
    ProductService service;

    @Test
    void findAllTest(){
        //given
        Mockito.when(productOutputPort.findAll()).thenReturn(productsDto);
        Mockito.when(mapper.mapRequest(Mockito.any())).thenReturn(product);
        //when
        List<Product> products2 = service.findAll();
        //then
        Assertions.assertEquals(1, products2.size());
    }

    @Test
    void saveTest(){
        //given
        Mockito.when(mapper.mapRequest(Mockito.any())).thenReturn(product);
        //when
        Product vos = service.save(productDto);
        //then
        Assertions.assertEquals(vos.getId(),priceDto.getId());
    }

    @Test
    void deleteTest(){
        //when
        service.delete("1");
        //then
        Mockito.verify(productOutputPort).delete(Mockito.any());
    }
}