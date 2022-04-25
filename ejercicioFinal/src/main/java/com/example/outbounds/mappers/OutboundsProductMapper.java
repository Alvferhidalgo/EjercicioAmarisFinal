package com.example.outbounds.mappers;

import com.example.commons.dtos.ProductDto;
import com.example.outbounds.entities.ProductEntity;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OutboundsProductMapper extends DtoMapper<ProductDto, ProductEntity, ProductDto> {
  @Override
  @Mapping(target = "prices", ignore = true)
  ProductDto mapResponse(ProductEntity vo);
}
