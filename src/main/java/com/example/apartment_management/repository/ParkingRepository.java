package com.example.apartment_management.repository;

import com.example.apartment_management.model.Parking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends MongoRepository<Parking, String> {
    List<Parking> findByStatus(String status);
}
