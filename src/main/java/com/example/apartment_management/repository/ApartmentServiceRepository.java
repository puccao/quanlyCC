package com.example.apartment_management.repository;

import com.example.apartment_management.model.ApartmentService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentServiceRepository extends MongoRepository<ApartmentService, String> {
}
