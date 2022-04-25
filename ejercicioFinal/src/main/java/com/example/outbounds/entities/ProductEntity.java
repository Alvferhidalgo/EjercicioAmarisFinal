package com.example.outbounds.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("PRODUCTS")
public class ProductEntity implements Serializable {

  @Id
  private String id;

  @OneToMany(mappedBy = "product")
  private List<PriceEntity> prices;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String name;

  private Long category;

  private LocalDateTime endOfSalesDate;

}
