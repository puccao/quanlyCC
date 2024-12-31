package com.example.apartment_management.repository;

import com.example.apartment_management.model.UtilityBill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilityBillRepository extends MongoRepository<UtilityBill, String> {
    List<UtilityBill> findByApartmentId(String apartmentId);
}
