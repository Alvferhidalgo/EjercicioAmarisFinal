package com.example.testdelejercicio;

import com.example.commons.dtos.PriceDto;
import com.example.inbounds.rest.controllers.PriceController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class CasosTest {

    String PRODUCT_ID = "35455";
    String BRAND_ID = "1";
    String DATE1 = LocalDateTime.of(2020, 6, 14, 10, 0, 0).toString();
    String DATE2 = LocalDateTime.of(2020, 6, 14, 16, 0, 0).toString();
    String DATE3 = LocalDateTime.of(2020, 6, 14, 21, 0, 0).toString();
    String DATE4 = LocalDateTime.of(2020, 6, 15, 10, 0, 0).toString();
    String DATE5 = LocalDateTime.of(2020, 6, 16, 21, 0, 0).toString();

    @Autowired
    PriceController controller;

    @Test
    @DisplayName("Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test1() {
        List<PriceDto> prices = controller.findByDateProductBrand(DATE1, PRODUCT_ID, BRAND_ID);
        Assertions.assertEquals(1, prices.size());
    }

    @Test
    @DisplayName("Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test2() {
        List<PriceDto> prices = controller.findByDateProductBrand(DATE2, PRODUCT_ID, BRAND_ID);
        Assertions.assertEquals(2, prices.size());
    }

    @Test
    @DisplayName("Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test3() {
        List<PriceDto> prices = controller.findByDateProductBrand(DATE3, PRODUCT_ID, BRAND_ID);
        Assertions.assertEquals(1, prices.size());
    }

    @Test
    @DisplayName("Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void test4() {
        List<PriceDto> prices = controller.findByDateProductBrand(DATE4, PRODUCT_ID, BRAND_ID);
        Assertions.assertEquals(2, prices.size());
    }

    @Test
    @DisplayName("Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void test5() {
        List<PriceDto> prices = controller.findByDateProductBrand(DATE5, PRODUCT_ID, BRAND_ID);
        Assertions.assertEquals(1, prices.size());
    }
}
