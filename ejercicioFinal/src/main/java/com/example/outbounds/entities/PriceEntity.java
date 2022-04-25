package com.example.outbounds.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("PRICES")
public class PriceEntity implements Serializable {

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "brand_id")

  private BrandEntity brand;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private ProductEntity product;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Integer priceList;

  private Integer priority;

  private Double price;

  private String currency;
}
