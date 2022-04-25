package com.example.outbounds.repositories;

import com.example.outbounds.entities.PriceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceEntityRepository extends MongoRepository<PriceEntity, String> {
}