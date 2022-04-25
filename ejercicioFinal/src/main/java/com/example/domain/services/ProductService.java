package com.example.domain.services;

import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Product;
import com.example.inbounds.mappers.InboundsProductMapper;
import com.example.inbounds.ports.in.ProductInputPort;
import com.example.outbounds.ports.ProductOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService implements ProductInputPort {

  private final ProductOutputPort productOutputPort;
  private final InboundsProductMapper productMapper;

  @Override
  public List<Product> findAll() {
    return productOutputPort.findAll().stream().map(productMapper::mapRequest).collect(Collectors.toList());
  }

  @Override
  public Product save(final ProductDto dto) {
    return productMapper.mapRequest(productOutputPort.save(dto));
  }

  @Override
  public void delete(final String id) {
    productOutputPort.delete(id);
  }

}
