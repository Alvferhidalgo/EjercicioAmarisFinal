package com.example.inbounds.mappers;

import com.example.commons.dtos.BrandDto;
import com.example.domain.vos.Brand;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InboundsBrandMapper extends DtoMapper<BrandDto, Brand, BrandDto> {

  @Override
  @Mapping(target = "prices", ignore = true)
  BrandDto mapResponse(Brand vo);
}
