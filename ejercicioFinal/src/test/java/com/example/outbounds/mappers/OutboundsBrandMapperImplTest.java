package com.example.outbounds.mappers;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Price;
import com.example.outbounds.entities.BrandEntity;
import com.example.outbounds.entities.PriceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OutboundsBrandMapperImplTest {

    @InjectMocks
    OutboundsBrandMapperImpl mapper;

    LocalDateTime DATE = LocalDateTime.of(1988, 10, 2, 10, 00, 00);
    List<Price> prices = new ArrayList<Price>();
    List<PriceEntity> pricesEntity = new ArrayList<PriceEntity>();
    BrandEntity brandEntity = new BrandEntity("1", "1", pricesEntity);
    List<PriceDto> pricesDto = new ArrayList<PriceDto>();
    BrandDto brandDto = new BrandDto("1", "1", pricesDto);
    ProductDto productDto = new ProductDto("1", null, DATE, DATE, "1", 1L, DATE);
    PriceDto priceDto = new PriceDto("1", brandDto, productDto, DATE, DATE, 1, 1, 1D, "1");
    BrandEntity brandEntityNull = null;
    List<BrandEntity> brandEntitiesNull = null;
    BrandDto brandDtoNull = null;
    ProductDto productDtoNull = null;
    PriceDto priceDtoNull = null;

    @Test
    void mapRequestNullTest() {
        var mapped = mapper.mapRequest(brandDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void priceDtoToPriceNull() {
        var mapped = mapper.priceDtoToPriceEntity(priceDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void priceDtoToPrice() {
        var mapped = mapper.productDtoToProductEntity(productDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseNull() {
        var mapped = mapper.mapResponse(brandEntityNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseListNull() {
        var mapped = mapper.mapResponseList(brandEntitiesNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void productDtoToProductEntity() {
        var mapped = mapper.productDtoToProductEntity(productDto);
        Assertions.assertNotNull(mapped);
    }

    @Test
    void priceDtoToPriceEntityTest() {
        var mapped = mapper.priceDtoToPriceEntity(priceDto);
        Assertions.assertNotNull(mapped);
    }

    @Test
    void mapResponseList() {
        var mapped = mapper.mapResponseList(List.of(brandEntity));
        Assertions.assertEquals("1", mapped.get(0).getId());
    }

    @Test
    void mapRequest() {
        var mapped = mapper.mapRequest(brandDto);
        Assertions.assertEquals("1", mapped.getId());
    }

    @Test
    void mapResponse() {
        var mapped = mapper.mapResponse(brandEntity);
        Assertions.assertEquals("1", mapped.getId());
    }


    @Test
    void priceDtoListToPriceListTest() {
        var mapped = mapper.priceDtoListToPriceEntityList(List.of(priceDto));
        Assertions.assertEquals("1", mapped.get(0).getId());
    }
}