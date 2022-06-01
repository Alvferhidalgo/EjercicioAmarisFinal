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

    BrandEntity brandEntity = new BrandEntity("1","Zara", null);

    @Mock
    BrandRepository repository;

    @InjectMocks
    BrandDao dao;

    @Test
    void saveTest() {
        //when
        dao.save(brandEntity);
        //then
        Mockito.verify(repository).save(brandEntity);
    }
}