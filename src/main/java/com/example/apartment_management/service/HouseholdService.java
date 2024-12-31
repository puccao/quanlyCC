package com.example.apartment_management.service;

import com.example.apartment_management.model.Household;
import com.example.apartment_management.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {
    @Autowired
    private HouseholdRepository householdRepository;

    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    public Household getHouseholdById(String id) {
        return householdRepository.findById(id).orElse(null);
    }

    public Household saveHousehold(Household household) {
        return householdRepository.save(household);
    }

    public void deleteHousehold(String id) {
        householdRepository.deleteById(id);
    }
}
