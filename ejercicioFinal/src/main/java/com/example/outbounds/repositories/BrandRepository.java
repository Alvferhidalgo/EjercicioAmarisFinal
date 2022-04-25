package com.example.outbounds.repositories;

import com.example.outbounds.entities.BrandEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepository extends MongoRepository<BrandEntity, String> {
}
