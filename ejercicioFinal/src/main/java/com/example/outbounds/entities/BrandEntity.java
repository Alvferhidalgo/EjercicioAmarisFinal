package com.example.outbounds.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("BRANDS")
public class BrandEntity implements Serializable {

  @Id
  private String id;

  private String name;

  @OneToMany(mappedBy = "brand")
  private List<PriceEntity> prices;
}
