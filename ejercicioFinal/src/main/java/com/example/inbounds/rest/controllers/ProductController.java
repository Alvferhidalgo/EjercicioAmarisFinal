package com.example.inbounds.rest.controllers;

import com.example.inbounds.kafka.constants.KafkaConstants;
import com.example.inbounds.kafka.producer.KafkaProductProducer;
import com.example.commons.EndpointsConstants;
import com.example.commons.dtos.ProductDto;
import com.example.inbounds.mappers.InboundsProductMapper;
import com.example.inbounds.ports.in.ProductInputPort;
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
public class ProductController {

  private final ProductInputPort productInputPort;
  private final KafkaProductProducer producer;
  private final InboundsProductMapper productMapper;

  @GetMapping(EndpointsConstants.FIND_ALL_PRODUCTS)
  public List<ProductDto> findAllProducts() {
    return productInputPort.findAll().stream().map(productMapper::mapResponse).collect(Collectors.toList());
  }

  @PostMapping(EndpointsConstants.CREATE_PRODUCTS)
  public ResponseEntity<ProductDto> save(@RequestBody final ProductDto dto) {
    if (dto.getId() != null) {
      return ResponseEntity.badRequest().build();
    }

    ProductDto productDto = productMapper.mapResponse(this.productInputPort.save(dto));
    producer.sendString(KafkaConstants.STATUS_CREATED + productDto.toString());
    return ResponseEntity.ok(productDto);
  }

  @PutMapping(EndpointsConstants.UPDATE_PRODUCTS)
  public ResponseEntity<ProductDto> update(@RequestBody final ProductDto dto) {
    if (dto.getId() == null) {
      return ResponseEntity.badRequest().build();
    }

    ProductDto productDto = productMapper.mapResponse(this.productInputPort.save(dto));
    producer.sendString(KafkaConstants.STATUS_UPDATED + productDto);
    return ResponseEntity.ok(productDto);
  }

  @DeleteMapping(EndpointsConstants.DELETE_PRODUCTS)
  public ResponseEntity<ProductDto> deleteById(@PathVariable final String id) {
    this.productInputPort.delete(id);
    producer.sendString(KafkaConstants.STATUS_DELETED + id);
    return ResponseEntity.noContent().build();
  }

}
