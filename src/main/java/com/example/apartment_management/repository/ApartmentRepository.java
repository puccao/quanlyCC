package com.example.apartment_management.repository;

import com.example.apartment_management.model.Apartment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends MongoRepository<Apartment, String> {
}
