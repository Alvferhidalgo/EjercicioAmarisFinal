package com.example.inbounds.rest.controllers;

import com.example.commons.EndpointsConstants;
import com.example.commons.dtos.PriceDto;
import com.example.inbounds.mappers.InboundsPriceMapper;
import com.example.inbounds.ports.in.PriceInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PriceController {

  private final PriceInputPort priceInputPort;
  private final InboundsPriceMapper priceMapper;

  @GetMapping(EndpointsConstants.FIND_ALL_PRICES)
  public List<PriceDto> findAllPrices() {
    return priceInputPort.findAll().stream().map(priceMapper::mapResponse).collect(Collectors.toList());
  }

  @PostMapping(EndpointsConstants.CREATE_PRICES)
  public ResponseEntity<PriceDto> save(@RequestBody final PriceDto dto) {
    if (dto.getId() != null) {
      return ResponseEntity.badRequest().build();
    }

    PriceDto priceDto = priceMapper.mapResponse(this.priceInputPort.save(dto));
    return ResponseEntity.ok(priceDto);
  }

  @PutMapping(EndpointsConstants.UPDATE_PRICES)
  public ResponseEntity<PriceDto> update(@RequestBody final PriceDto dto) {
    if (dto.getId() == null) {
      return ResponseEntity.badRequest().build();
    }

    PriceDto priceDto = priceMapper.mapResponse(this.priceInputPort.save(dto));
    return ResponseEntity.ok(priceDto);
  }

  @DeleteMapping(EndpointsConstants.DELETE_PRICES)
  public ResponseEntity<PriceDto> deleteById(@PathVariable final String id) {
    this.priceInputPort.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping(EndpointsConstants.FIND_BY_DATE_PRODUCT_BRAND)
  public List<PriceDto> findByDateProductBrand(@PathVariable final String applicationDate, @PathVariable final String productId,
      @PathVariable final String brandId) {
    return priceInputPort.findByDateProductBrand(applicationDate, productId, brandId).stream().map(priceMapper::mapResponse)
        .collect(Collectors.toList());
  }

}
