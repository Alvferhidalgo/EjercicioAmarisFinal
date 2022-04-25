package com.example.outbounds.dao.productdao;

import com.example.commons.dtos.ProductDto;
import com.example.outbounds.entities.ProductEntity;
import com.example.outbounds.mappers.OutboundsProductMapper;
import com.example.outbounds.repositories.ProductEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductDaoTest {

    ProductEntity product = new ProductEntity();
    ProductDto productDto = new ProductDto();
    List<ProductEntity> products = List.of(product);

    @Mock
    ProductEntityRepository repository;

    @Mock
    OutboundsProductMapper mapper;

    @InjectMocks
    ProductDao dao;

    @Test
    void findAllTest() {
        //given
        Mockito.when(repository.findAll()).thenReturn(products);
        //when
        List<ProductDto> productDto = dao.findAll();
        //then
        Assertions.assertEquals(1,products.size());
    }

    @Test
    void saveTest() {
        //given
        Mockito.when(repository.save(Mockito.any())).thenReturn(product);
        Mockito.when(mapper.mapResponse(Mockito.any())).thenReturn(productDto);
        //when
        ProductDto product = dao.save(productDto);
        //then
        Assertions.assertEquals(product.getId(),productDto.getId());
    }

    @Test
    void deleteTest() {
        //when
        dao.delete("1");
        //then
        Mockito.verify(repository).deleteById(Mockito.any());
    }
}