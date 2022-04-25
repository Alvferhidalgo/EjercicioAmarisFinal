package com.example.testdelejercicio;

import org.springframework.boot.test.context.SpringBootTest;

//NOTA: Este test solo sirve para dar valores iniciales a la base de datos.
@SpringBootTest
public class InitializeDatabaseTest {
/*
    @Autowired
    PriceDao pricedao;

    @Autowired
    BrandDao brandDao;

    @Autowired
    ProductDao productDao;

    @Test
    public void test() {

        String currency = "EUR";
        LocalDateTime productDatedate = LocalDateTime.of(2020, 10, 10, 10, 10, 10);

        LocalDateTime date1 = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        LocalDateTime date2 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        LocalDateTime
                date3 = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
        LocalDateTime date4 = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
        LocalDateTime date5 =
                LocalDateTime.of(2020, 6, 15, 0, 0, 0);
        LocalDateTime date6 = LocalDateTime.of(2020, 6, 15, 11, 0, 0);
        LocalDateTime date7 =
                LocalDateTime.of(2020, 6, 15, 16, 0, 0);
        LocalDateTime date8 = LocalDateTime.of(2020, 6, 14, 0, 0, 0);

        ProductDto product = new ProductDto("35455", null, productDatedate, productDatedate, "itemExample", 1L, productDatedate);
        productDao.save(product);

        BrandDto brand = new BrandDto("1", "Zara", null);
        BrandEntity brandEntity = new BrandEntity("1","Zara", null);
        brandDao.save(brandEntity);

        PriceDto price1 = new PriceDto("2", brand, product, date1, date2, 1, 0, 35.50, currency);
        PriceDto price2 = new PriceDto("3", brand,
                product, date3, date4, 2, 1, 25.45, currency);
        PriceDto price3 = new PriceDto("4", brand, product, date5, date6, 3, 1, 30.50, currency);
        PriceDto price4 = new PriceDto("5", brand, product, date7, date8, 4, 1, 38.95, currency);

        pricedao.save(price1);
        pricedao.save(price2);
        pricedao.save(price3);
        pricedao.save(price4);

    }
*/

}
