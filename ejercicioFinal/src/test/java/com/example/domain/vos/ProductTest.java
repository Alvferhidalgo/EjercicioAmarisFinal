package com.example.domain.vos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class ProductTest {

    private final Long LONG_VALUE = 1L;
    private final Long LONG_VALUE_2 = 2L;
    private final String STRING_VALUE = "value";
    private final
    String STRING_VALUE_2 = "value2";
    private final LocalDateTime DATE = LocalDateTime.of(2022, 10, 10, 10, 10, 10);
    private final LocalDateTime
            DATE2 = LocalDateTime.of(2022, 10, 10, 10, 10, 11);

    private final List<Price> PRICES = new ArrayList<>();
    private final List<Price> PRICES2 = new ArrayList<>();

    Product productEmpty = new Product();
    Product product = new Product(STRING_VALUE, PRICES, DATE, DATE, STRING_VALUE, LONG_VALUE, DATE);

    @Test
    void emptyConstructorTest() {
        int hash = productEmpty.hashCode();
        Assertions.assertEquals(hash, productEmpty.hashCode());
    }

    @Test
    void getId() {
        Assertions.assertEquals(product.getId(), STRING_VALUE);
    }

    @Test
    void getPrices() {
        Assertions.assertEquals(product.getPrices(), PRICES);
    }

    @Test
    void getCreatedAt() {
        Assertions.assertEquals(product.getCreatedAt(), DATE);
    }

    @Test
    void getUpdatedAt() {
        Assertions.assertEquals(product.getUpdatedAt(), DATE);
    }

    @Test
    void getName() {
        Assertions.assertEquals(product.getName(), STRING_VALUE);
    }

    @Test
    void getCategory() {
        Assertions.assertEquals(product.getCategory(), LONG_VALUE);
    }

    @Test
    void getEndOfSalesDate() {
        Assertions.assertEquals(product.getEndOfSalesDate(), DATE);
    }

    @Test
    void setId() {
        product.setId(STRING_VALUE_2);
        Assertions.assertEquals(product.getId(), STRING_VALUE_2);
    }

    @Test
    void setPrices() {
        product.setPrices(PRICES2);
        Assertions.assertEquals(product.getPrices(), PRICES2);
    }

    @Test
    void setCreatedAt() {
        product.setCreatedAt(DATE2);
        Assertions.assertEquals(product.getCreatedAt(), DATE2);
    }

    @Test
    void setUpdatedAt() {
        product.setUpdatedAt(DATE2);
        Assertions.assertEquals(product.getUpdatedAt(), DATE2);
    }

    @Test
    void setName() {
        product.setName(STRING_VALUE_2);
        Assertions.assertEquals(product.getName(), STRING_VALUE_2);
    }

    @Test
    void setCategory() {
        product.setCategory(LONG_VALUE_2);
        Assertions.assertEquals(product.getCategory(), LONG_VALUE_2);
    }

    @Test
    void setEndOfSalesDate() {
        product.setEndOfSalesDate(DATE2);
        Assertions.assertEquals(product.getEndOfSalesDate(), DATE2);
    }

    @Test
    void testEquals() {
        Assertions.assertTrue(product.equals(product));
    }

    @Test
    void testToString() {
        String string = product.toString();
        Assertions.assertEquals(product.toString(), string);
    }


}
