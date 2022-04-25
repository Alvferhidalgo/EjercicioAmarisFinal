package com.example.inbounds.mappers;

import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Product;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InboundsProductMapper extends DtoMapper<ProductDto, Product, ProductDto> {

  @Override
  @Mapping(target = "prices", ignore = true)
  ProductDto mapResponse(Product vo);
}
