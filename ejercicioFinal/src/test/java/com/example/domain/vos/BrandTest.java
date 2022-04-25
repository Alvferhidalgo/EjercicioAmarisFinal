package com.example.domain.vos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BrandTest {


    private final String STRING_VALUE = "value";
    private final
    String STRING_VALUE_2 = "value2";

    List<Price> entities = new ArrayList<>();
    Brand brand = new Brand(STRING_VALUE, STRING_VALUE, entities);

    @Test
    void emptyConstructorTest() {
        Brand brandEmpty = new Brand();
        int hash = brandEmpty.hashCode();
        Assertions.assertEquals(hash, brandEmpty.hashCode());
    }

    @Test
    void getId() {
        Assertions.assertEquals(brand.getId(), STRING_VALUE);
    }

    @Test
    void getName() {
        Assertions.assertEquals(brand.getName(), STRING_VALUE);
    }

    @Test
    void getPrices() {
        Assertions.assertEquals(brand.getPrices(), entities);
    }

    @Test
    void setId() {
        brand.setId(STRING_VALUE_2);
        Assertions.assertEquals(brand.getId(), STRING_VALUE_2);
    }

    @Test
    void setName() {
        brand.setName(STRING_VALUE_2);
        Assertions.assertEquals(brand.getName(), STRING_VALUE_2);
    }

    @Test
    void setPrices() {
        List<Price> prices2 = new ArrayList<>();
        brand.setPrices(prices2);
        Assertions.assertEquals(brand.getPrices(),
                prices2);
    }

    @Test
    void testEquals() {
        Assertions.assertTrue(brand.equals(brand));
    }

    @Test
    void testToString() {
        String brandString = brand.toString();
        Assertions.assertEquals(brand.toString(), brandString);
    }

}