package com.example.outbounds.mappers;

import com.example.commons.dtos.PriceDto;
import com.example.outbounds.entities.PriceEntity;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OutboundsPriceMapper extends DtoMapper<PriceDto, PriceEntity, PriceDto> {
}
