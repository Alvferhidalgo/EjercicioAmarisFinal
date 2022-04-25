package com.example.inbounds.kafka.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

  private String productId;

  private Integer priceListId;

  private Double price;
}
