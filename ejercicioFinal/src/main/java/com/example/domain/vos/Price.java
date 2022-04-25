package com.example.domain.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

  private String id;

  private Brand brand;

  private Product product;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Integer priceList;

  private Integer priority;

  private Double price;

  private String currency;
}
