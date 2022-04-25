package com.example.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

  private String id;

  private List<PriceDto> prices;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String name;

  private Long category;

  private LocalDateTime endOfSalesDate;
}
