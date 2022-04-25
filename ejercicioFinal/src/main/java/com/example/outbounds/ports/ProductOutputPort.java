package com.example.outbounds.ports;

import com.example.commons.dtos.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductOutputPort {

  List<ProductDto> findAll();

  ProductDto save(ProductDto dto);

  void delete(String id);
}
