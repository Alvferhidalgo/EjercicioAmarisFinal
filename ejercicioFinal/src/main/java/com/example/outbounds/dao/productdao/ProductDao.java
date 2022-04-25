package com.example.outbounds.dao.productdao;

import com.example.outbounds.mappers.OutboundsProductMapper;
import com.example.outbounds.repositories.ProductEntityRepository;
import com.example.commons.dtos.ProductDto;
import com.example.outbounds.ports.ProductOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductDao implements ProductOutputPort {

  private final ProductEntityRepository productEntityRepository;
  private final OutboundsProductMapper productMapper;

  @Override
  public List<ProductDto> findAll() {
    return productEntityRepository.findAll().stream().map(productMapper::mapResponse).collect(Collectors.toList());
  }

  @Override
  public ProductDto save(final ProductDto dto) {

    return productMapper.mapResponse(productEntityRepository.save(productMapper.mapRequest(dto)));
  }

  @Override
  public void delete(final String id) {
    productEntityRepository.deleteById(id);
  }
}
