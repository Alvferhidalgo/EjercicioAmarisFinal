package com.example.outbounds.repositories;

import com.example.outbounds.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends MongoRepository<ProductEntity, String> {
}