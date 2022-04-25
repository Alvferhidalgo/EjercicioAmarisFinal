package com.example.inbounds.kafka.consumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductRequestTest {

    private final String STRING_VALUE = "1L";
    private final String STRING_VALUE_2 = "2L";
    private final Double DOUBLE_VALUE = 1D;
    private final Double DOUBLE_VALUE_2 = 2D;
    private final Integer INT_VALUE = 1;
    private final Integer INT_VALUE_2 = 2;
    private ProductRequest productRequest = new ProductRequest(STRING_VALUE, INT_VALUE, DOUBLE_VALUE);

    @Test
    void emptyConstructorTest() {
        ProductRequest productRequestEmpty = new ProductRequest();
        Integer hash = productRequest.hashCode();
        Assertions.assertEquals(productRequest.hashCode(), hash);
    }

    @Test
    void getProduct_id() {
        Assertions.assertEquals(productRequest.getProductId(), STRING_VALUE);
    }

    @Test
    void getPrice_list_id() {
        Assertions.assertEquals(productRequest.getPriceListId(), INT_VALUE);
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(productRequest.getPrice(), DOUBLE_VALUE);
    }

    @Test
    void setProduct_id() {
        productRequest.setProductId(STRING_VALUE_2);
        Assertions.assertEquals(productRequest.getProductId(), STRING_VALUE_2);
    }

    @Test
    void setPrice_list_id() {
        productRequest.setPriceListId(INT_VALUE_2);
        Assertions.assertEquals(productRequest.getPriceListId(), INT_VALUE_2);
    }

    @Test
    void setPrice() {
        productRequest.setPrice(DOUBLE_VALUE_2);
        Assertions.assertEquals(productRequest.getPrice(), DOUBLE_VALUE_2);
    }

    @Test
    void testEquals() {
        Assertions.assertTrue(productRequest.equals(productRequest));
    }

    @Test
    void testToString() {
        String productRequestString = productRequest.toString();
        Assertions.assertEquals(productRequest.toString(), productRequestString);
    }
}