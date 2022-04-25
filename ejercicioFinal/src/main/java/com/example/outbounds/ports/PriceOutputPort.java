package com.example.outbounds.ports;

import com.example.commons.dtos.PriceDto;

import java.util.List;

public interface PriceOutputPort {

  List<PriceDto> findAll();

  PriceDto save(PriceDto dto);

  void saveAll(List<PriceDto> dto);

  void delete(String id);
}
