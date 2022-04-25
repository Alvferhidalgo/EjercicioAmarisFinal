package com.example.outbounds.mappers;

import com.example.commons.dtos.BrandDto;
import com.example.outbounds.entities.BrandEntity;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OutboundsBrandMapper extends DtoMapper<BrandDto, BrandEntity, BrandDto> {

  @Override
  @Mapping(target = "prices", ignore = true)
  BrandDto mapResponse(BrandEntity vo);
}
