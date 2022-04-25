package com.example.domain.services;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import com.example.inbounds.mappers.InboundsPriceMapper;
import com.example.outbounds.ports.PriceOutputPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class PriceServiceTest {

    LocalDateTime DATE = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
    BrandDto brandDto = new BrandDto();
    ProductDto productDto = new ProductDto();
    PriceDto priceDto = new PriceDto("1", brandDto, productDto, DATE, DATE, 1, 1, 1D, "EUR");

    List<PriceDto> priceDtos = List.of(priceDto);

    Brand brand = new Brand("1", "Zara", null);
    Product product = new Product("1", null, DATE, DATE, "1", 1L, DATE);
    Price price = new Price("1", brand, product, DATE, DATE, 1, 1, 1D, "EUR");
    List<Price> prices = List.of(price);

    @Mock
    InboundsPriceMapper mapper;

    @Mock
    PriceOutputPort priceOutputPort;

    @InjectMocks
    PriceService service;

    @Test
    void findAllTest() {

        //when
        Mockito.when(priceOutputPort.findAll()).thenReturn(priceDtos);
        Mockito.when(mapper.mapRequest(Mockito.any())).thenReturn(price);

        List<Price> prices2 = service.findAll();
        //then
        Assertions.assertEquals(prices.size(), prices2.size());
    }

    @Test
    void saveTest() {
        //given
        Mockito.when(mapper.mapRequest(Mockito.any())).thenReturn(price);
        //when
        Price vos = service.save(priceDto);
        //then
        Assertions.assertEquals(vos.getId(), priceDto.getId());
    }

    @Test
    void deleteTest() {
        //when
        service.delete("1");
        //then
        Mockito.verify(priceOutputPort).delete(Mockito.any());
    }

    @Test
    void updateFromRequestTest() {
        //given
        Mockito.when(priceOutputPort.findAll()).thenReturn(priceDtos);
        Mockito.when(mapper.mapRequest(Mockito.any())).thenReturn(price);
        //when
        service.updateFromRequest("1", 1, 1D);
        //then
        Mockito.verify(priceOutputPort).saveAll(Mockito.any());
    }

    @Test
    void findByDateProductBrandTest() {
        //given
        Mockito.when(priceOutputPort.findAll()).thenReturn(priceDtos);
        Mockito.when(mapper.mapRequest(Mockito.any())).thenReturn(price);
        //when
        List<Price> prices2 = service.findByDateProductBrand(DATE.toString(), "1", "1");
        //then
        Assertions.assertEquals(prices2.size(), 1);
    }
}