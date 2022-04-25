package com.example.inbounds.ports.in;

import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Product;

import java.util.List;

public interface ProductInputPort {
  List<Product> findAll();

  Product save(ProductDto dto);

  void delete(String id);
}
