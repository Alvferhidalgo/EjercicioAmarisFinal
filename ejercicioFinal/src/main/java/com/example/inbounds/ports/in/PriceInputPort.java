package com.example.inbounds.ports.in;

import com.example.commons.dtos.PriceDto;
import com.example.domain.vos.Price;

import java.util.List;

public interface PriceInputPort {

  List<Price> findAll();

  Price save(PriceDto priceDto);

  void delete(String id);

  List<Price> findByDateProductBrand(String applicationDate, String productId, String brandId);

  void updateFromRequest(String productId, Integer priceListId, Double price);
}
