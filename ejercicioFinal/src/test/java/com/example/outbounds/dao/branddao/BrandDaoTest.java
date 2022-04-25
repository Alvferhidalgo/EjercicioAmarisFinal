package com.example.outbounds.dao.branddao;

import com.example.outbounds.entities.BrandEntity;
import com.example.outbounds.repositories.BrandRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BrandDaoTest {

    BrandEntity brand = new BrandEntity("1","Zara", null);

    @Mock
    BrandRepository repository;

    @InjectMocks
    BrandDao dao;

    @Test
    void saveTest() {
        //when
        dao.save(brand);
        //then
        Mockito.verify(repository).save(brand);
    }
}