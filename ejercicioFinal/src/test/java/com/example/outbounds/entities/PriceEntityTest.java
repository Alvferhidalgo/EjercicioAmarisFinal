package com.example.outbounds.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class PriceEntityTest {

    private final Double DOUBLE_VALUE = 1D;
    private final Double
            DOUBLE_VALUE_2 = 2D;
    private final Integer INTEGER_VALUE = 1;
    private final Integer INTEGER_VALUE_2 = 2;
    private final String
            STRING_VALUE = "value";
    private final String STRING_VALUE_2 = "value2";
    private final LocalDateTime DATE =
            LocalDateTime.of(2022, 10, 10, 10, 10, 10);
    private final LocalDateTime DATE2 = LocalDateTime.of(2022, 10, 10, 10, 10, 11);
    private final
    BrandEntity BRAND = new BrandEntity();
    private final ProductEntity PRODUCT = new ProductEntity();

    PriceEntity priceSampleEmpty = new PriceEntity();
    PriceEntity priceSample = new
            PriceEntity(STRING_VALUE, BRAND, PRODUCT, DATE, DATE, INTEGER_VALUE, INTEGER_VALUE, DOUBLE_VALUE, STRING_VALUE);


    @Test
    void emptyConstructorTest() {
        Integer hash = priceSampleEmpty.hashCode();
        Assertions.assertEquals(priceSampleEmpty.hashCode(), hash);
    }

    @Test
    void getId() {
        Assertions.assertEquals(priceSample.getId(), STRING_VALUE);
    }

    @Test
    void getBrand() {
        Assertions.assertEquals(priceSample.getBrand(), BRAND);
    }

    @Test
    void getProduct() {
        Assertions.assertEquals(priceSample.getProduct(), PRODUCT);
    }

    @Test
    void getStartDate() {
        Assertions.assertEquals(priceSample.getStartDate(), DATE);
    }

    @Test
    void getEndDate() {
        Assertions.assertEquals(priceSample.getEndDate(), DATE);
    }

    @Test
    void getPrice_list() {
        Assertions.assertEquals(priceSample.getPriceList(), INTEGER_VALUE);
    }

    @Test
    void getPriority() {
        Assertions.assertEquals(priceSample.getPriority(), INTEGER_VALUE);
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(priceSample.getPrice(), DOUBLE_VALUE);
    }

    @Test
    void getCurrency() {
        Assertions.assertEquals(priceSample.getCurrency(), STRING_VALUE);
    }

    @Test
    void setId() {
        priceSample.setId(STRING_VALUE_2);
        Assertions.assertEquals(priceSample.getId(), STRING_VALUE_2);
    }

    @Test
    void setBrand() {
        BrandEntity brand2 = new BrandEntity();
        priceSample.setBrand(brand2);
        Assertions.assertEquals(priceSample.getBrand(), brand2);
    }

    @Test
    void setProduct() {
        ProductEntity product2 = new ProductEntity();
        priceSample.setProduct(product2);
        Assertions.assertEquals(priceSample.getProduct(), product2);
    }

    @Test
    void setStartDate() {
        priceSample.setStartDate(DATE2);
        Assertions.assertEquals(priceSample.getStartDate(), DATE2);
    }

    @Test
    void setEndDate() {
        priceSample.setEndDate(DATE2);
        Assertions.assertEquals(priceSample.getEndDate(), DATE2);
    }

    @Test
    void setPrice_list() {
        priceSample.setPriceList(INTEGER_VALUE_2);
        Assertions.assertEquals(priceSample.getPriceList(), INTEGER_VALUE_2);
    }

    @Test
    void setPriority() {
        priceSample.setPriority(INTEGER_VALUE_2);
        Assertions.assertEquals(priceSample.getPriority(), INTEGER_VALUE_2);
    }

    @Test
    void setPrice() {
        priceSample.setPrice(DOUBLE_VALUE_2);
        Assertions.assertEquals(priceSample.getPrice(), DOUBLE_VALUE_2);
    }

    @Test
    void setCurrency() {
        priceSample.setCurrency(STRING_VALUE_2);
        Assertions.assertEquals(priceSample.getCurrency(), STRING_VALUE_2);
    }

    @Test
    void testEquals() {
        Assertions.assertTrue(priceSample.equals(priceSample));
    }

    @Test
    void testToString() {
        String price = priceSample.toString();
        Assertions.assertEquals(priceSample.toString(), price);
    }


}