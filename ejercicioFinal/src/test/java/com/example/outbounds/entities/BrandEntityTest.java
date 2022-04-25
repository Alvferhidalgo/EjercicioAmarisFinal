package com.example.outbounds.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BrandEntityTest {

    private final String STRING_VALUE = "value";
    private final
    String STRING_VALUE_2 = "value2";

    List<PriceEntity> entities = new ArrayList<PriceEntity>();
    BrandEntity brandEntity = new BrandEntity(STRING_VALUE, STRING_VALUE, entities);

    @Test
    void emptyConstructorTest() {
        BrandEntity entityEmpty = new BrandEntity();
        int hash = entityEmpty.hashCode();
        Assertions.assertEquals(hash, entityEmpty.hashCode());
    }

    @Test
    void getId() {
        Assertions.assertEquals(brandEntity.getId(), STRING_VALUE);
    }

    @Test
    void getName() {
        Assertions.assertEquals(brandEntity.getName(), STRING_VALUE);
    }

    @Test
    void getPrices() {
        Assertions.assertEquals(brandEntity.getPrices(), entities);
    }

    @Test
    void setId() {
        brandEntity.setId(STRING_VALUE_2);
        Assertions.assertEquals(brandEntity.getId(), STRING_VALUE_2);
    }

    @Test
    void setName() {
        brandEntity.setName(STRING_VALUE_2);
        Assertions.assertEquals(brandEntity.getName(), STRING_VALUE_2);
    }

    @Test
    void setPrices() {
        List<PriceEntity> entities2 = new ArrayList<PriceEntity>();
        brandEntity.setPrices(entities2);
        Assertions.assertEquals(brandEntity.getPrices(), entities2);
    }

    @Test
    void testEquals() {
        Assertions.assertTrue(brandEntity.equals(brandEntity));
    }

    @Test
    void testToString() {
        String brandEntityString = brandEntity.toString();
        Assertions.assertEquals(brandEntity.toString(),
                brandEntityString);
    }

}