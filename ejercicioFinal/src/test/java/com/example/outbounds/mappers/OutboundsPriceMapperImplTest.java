package com.example.outbounds.mappers;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.outbounds.entities.BrandEntity;
import com.example.outbounds.entities.PriceEntity;
import com.example.outbounds.entities.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OutboundsPriceMapperImplTest {

    @InjectMocks
    OutboundsPriceMapperImpl mapper;

    LocalDateTime DATE = LocalDateTime.of(1988, 10, 2, 10, 00, 00);
    ProductEntity productEntity = new ProductEntity("1", null, DATE, DATE, "1", 1L, DATE);
    List<PriceEntity> pricesEntity = new ArrayList<PriceEntity>();
    BrandEntity brandEntity = new BrandEntity("1", "1", pricesEntity);
    PriceEntity priceEntity = new PriceEntity("1", brandEntity, productEntity, DATE, DATE, 1, 1, 1D, "1");
    List<PriceDto> pricesDto = new ArrayList<PriceDto>();
    BrandDto brandDto = new BrandDto("1", "1", pricesDto);
    ProductDto productDto = new ProductDto("1", null, DATE, DATE, "1", 1L, DATE);
    PriceDto priceDto = new PriceDto("1", brandDto, productDto, DATE, DATE, 1, 1, 1D, "1");
    BrandEntity brandEntityNull = null;
    PriceEntity priceEntityNull = null;
    ProductEntity productEntityNull = null;
    List<PriceEntity> priceEntitiesNull = null;
    BrandDto brandDtoNull = null;
    ProductDto productDtoNull = null;
    PriceDto priceDtoNull = null;

    @Test
    void mapRequestNullTest() {
        var mapped = mapper.mapRequest(priceDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void brandEntityToBrandDtoNull() {
        var mapped = mapper.brandEntityToBrandDto(brandEntityNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void priceDtoToPriceNull() {
        var mapped = mapper.productDtoToProductEntity(productDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void productEntityToProductDtoNull() {
        var mapped = mapper.productEntityToProductDto(productEntityNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void brandDtoToBrandEntityNull() {
        var mapped = mapper.brandDtoToBrandEntity(brandDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseNull() {
        var mapped = mapper.mapResponse(priceEntityNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseListNull() {
        var mapped = mapper.mapResponseList(priceEntitiesNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void productDtoToProductEntity() {
        var mapped = mapper.productDtoToProductEntity(productDto);
        Assertions.assertNotNull(mapped);
    }

    @Test
    void mapResponseList() {
        var mapped = mapper.mapResponseList(List.of(priceEntity));
        Assertions.assertEquals("1", mapped.get(0).getId());
    }

    @Test
    void mapRequest() {
        var mapped = mapper.mapRequest(priceDto);
        Assertions.assertEquals("1", mapped.getId());
    }

    @Test
    void mapResponse() {
        var mapped = mapper.mapResponse(priceEntity);
        Assertions.assertEquals("1", mapped.getId());
    }

    @Test
    void priceDtoListToPriceListTest() {
        var mapped = mapper.priceDtoListToPriceEntityList(List.of(priceDto));
        Assertions.assertEquals("1", mapped.get(0).getId());
    }
}