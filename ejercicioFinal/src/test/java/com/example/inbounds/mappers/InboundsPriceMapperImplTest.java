package com.example.inbounds.mappers;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class InboundsPriceMapperImplTest {


    LocalDateTime DATE = LocalDateTime.of(1988, 10, 2, 10, 00, 00);
    Product product = new Product("1", null, DATE, DATE, "1", 1L, DATE);
    List<Price> prices = new ArrayList<Price>();
    Brand brand = new Brand("1", "1", prices);
    Price price = new Price("1", brand, product, DATE, DATE, 1, 1, 1D, "1");
    List<PriceDto> pricesDto = new ArrayList<PriceDto>();
    BrandDto brandDto = new BrandDto("1", "1", pricesDto);
    ProductDto productDto = new ProductDto("1", null, DATE, DATE, "1", 1L, DATE);
    PriceDto priceDto = new PriceDto("1", brandDto, productDto, DATE, DATE, 1, 1, 1D, "1");
    Brand brandNull = null;
    Price priceNull = null;
    Product productNull = null;
    List<Price> priceListNull = null;
    BrandDto brandDtoNull = null;
    ProductDto productDtoNull = null;
    PriceDto priceDtoNull = null;

    @InjectMocks
    InboundsPriceMapperImpl mapper;

    @Test
    void mapRequestNullTest() {
        var mapped = mapper.mapRequest(priceDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void productDtoToProductNull() {
        var mapped = mapper.productDtoToProduct(productDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void priceDtoToPrice() {
        var mapped = mapper.brandDtoToBrand(brandDtoNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseNull() {
        var mapped = mapper.mapResponse(priceNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseListNull() {
        var mapped = mapper.mapResponseList(priceListNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void brandToBrandDtoNullTest() {
        var mapped = mapper.brandToBrandDto(brandNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void productToProductDtoNullTest() {
        var mapped = mapper.productToProductDto(productNull);
        Assertions.assertNull(mapped);
    }

    @Test
    void mapResponseList() {
        var mapped = mapper.mapResponseList(List.of(price));
        Assertions.assertEquals("1", mapped.get(0).getId());
    }

    @Test
    void mapRequest() {
        var mapped = mapper.mapRequest(priceDto);
        Assertions.assertEquals("1", mapped.getId());
    }

    @Test
    void mapResponse() {
        var mapped = mapper.mapResponse(price);
        Assertions.assertEquals("1", mapped.getId());
    }

    @Test
    void productDtoToProductTest() {
        var mapped = mapper.productDtoToProduct(productDto);
        Assertions.assertEquals("1", mapped.getId());
    }

    @Test
    void priceDtoListToPriceListTest() {
        var mapped = mapper.priceDtoListToPriceList(List.of(priceDto));
        Assertions.assertEquals("1", mapped.get(0).getId());
    }
}