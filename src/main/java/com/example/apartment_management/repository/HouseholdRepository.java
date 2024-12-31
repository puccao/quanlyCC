package com.example.apartment_management.repository;

import com.example.apartment_management.model.Household;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends MongoRepository<Household, String> {
}
