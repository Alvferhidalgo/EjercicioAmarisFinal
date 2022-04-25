package com.example.outbounds.dao.branddao;

import com.example.outbounds.entities.BrandEntity;
import com.example.outbounds.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class BrandDao {

  private final BrandRepository repository;

  @Transactional
  public void save(final BrandEntity brand) {
    repository.save(brand);
  }
}
