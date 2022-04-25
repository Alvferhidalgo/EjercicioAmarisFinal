package com.example.inbounds.mappers;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class InboundsBrandMapperImplTest {

    LocalDateTime DATE = LocalDateTime.of(1988, 10, 2, 10, 00, 00);
    List<Price> prices = new ArrayList<Price>();
    Brand brand = new Brand("1","1", prices);
    List<PriceDto> pricesDto = new ArrayList<PriceDto>();
    BrandDto brandDto = new BrandDto("1","1",pricesDto);
    ProductDto productDto = new ProductDto("1",null,DATE,DATE,"1",1L,DATE);
    PriceDto priceDto = new PriceDto("1",brandDto,productDto,DATE,DATE,1,1,1D,"1");
    List<Brand> brands = List.of(brand);


    Brand brandNull = null;
    List<Brand> brandListNull = null;
    BrandDto brandDtoNull = null;
    ProductDto productDtoNull = null;
    PriceDto priceDtoNull = null;

    @InjectMocks
    InboundsBrandMapperImpl mapper;

    @Test
    void mapRequestNullTest(){
        var mapped = mapper.mapRequest(brandDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void productDtoToProductNull(){
        var mapped = mapper.productDtoToProduct(productDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void priceDtoToPrice(){
        var mapped = mapper.priceDtoToPrice(priceDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseNull(){
        var mapped = mapper.mapResponse(brandNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseListNull(){
        var mapped = mapper.mapResponseList(brandListNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseList() {
        var mapped = mapper.mapResponseList(brands);
        Assertions.assertEquals("1",mapped.get(0).getId());
    }

    @Test
    void mapRequest() {
        var mapped = mapper.mapRequest(brandDto);
        Assertions.assertEquals("1",mapped.getId());
    }

    @Test
    void mapResponse() {
        var mapped = mapper.mapResponse(brand);
        Assertions.assertEquals("1",mapped.getId());
    }

    @Test
    void productDtoToProductTest() {
        var mapped = mapper.productDtoToProduct(productDto);
        Assertions.assertEquals("1",mapped.getId());
    }

    @Test
    void priceDtoToPriceTest() {
        var mapped = mapper.priceDtoToPrice(priceDto);
        Assertions.assertEquals("1",mapped.getId());
    }

    @Test
    void priceDtoListToPriceListTest(){
        var mapped = mapper.priceDtoListToPriceList(List.of(priceDto));
        Assertions.assertEquals("1",mapped.get(0).getId());
    }
}