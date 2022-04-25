package com.example.inbounds.mappers;

import com.example.commons.dtos.PriceDto;
import com.example.domain.vos.Price;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InboundsPriceMapper extends DtoMapper<PriceDto, Price, PriceDto> {
}
