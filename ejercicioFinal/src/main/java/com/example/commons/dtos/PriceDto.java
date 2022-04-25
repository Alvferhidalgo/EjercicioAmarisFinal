package com.example.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

  private String id;

  private BrandDto brand;

  private ProductDto product;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Integer priceList;

  private Integer priority;

  private Double price;

  private String currency;
}
