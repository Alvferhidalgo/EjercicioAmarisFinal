package com.example.outbounds.dao.pricedao;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.outbounds.entities.BrandEntity;
import com.example.outbounds.entities.PriceEntity;
import com.example.outbounds.entities.ProductEntity;
import com.example.outbounds.mappers.OutboundsPriceMapper;
import com.example.outbounds.repositories.PriceEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class PriceDaoTest {

    LocalDateTime DATE = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
    List<PriceEntity> prices = new ArrayList<>();
    List<PriceDto> pricesDto =
            new ArrayList<>();

    BrandEntity brand = new BrandEntity();
    ProductEntity product = new ProductEntity();
    PriceEntity priceEntity = new PriceEntity("1",
            brand, product, DATE, DATE, 1, 1, 1D, "EUR");

    BrandDto brandDto = new BrandDto();
    ProductDto productDto = new ProductDto();
    PriceDto priceDto = new PriceDto("1", brandDto,
            productDto, DATE, DATE, 1, 1, 1D, "EUR");

    @Mock
    PriceEntityRepository repository;

    @Mock
    OutboundsPriceMapper mapper;

    @InjectMocks
    PriceDao dao;

    @Test
    void findAllTest() {

        //given
        when(repository.findAll()).thenReturn(prices);

        //when
        List<PriceDto> pricesDto = dao.findAll();

        //then
        Assertions.assertEquals(pricesDto.size(), prices.size());

    }

    @Test
    void saveTest() {
        //given
        when(repository.save(Mockito.any())).thenReturn(priceEntity);
        when(mapper.mapResponse(Mockito.any())).thenReturn(priceDto);
        //when
        PriceDto price = dao.save(priceDto);
        //then
        Assertions.assertEquals(price.getId(), priceDto.getId());
    }

    @Test
    void saveAllTest() {

        //given
        when(repository.saveAll(Mockito.any())).thenReturn(prices);
        //when
        dao.saveAll(pricesDto);
        // then
        Mockito.verify(repository).saveAll(Mockito.any());
    }

    @Test
    void deleteTest() {
        //when
        dao.delete("1");
        //then
        Mockito.verify(repository).deleteById(Mockito.any()); }

    }