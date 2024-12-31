package com.example.apartment_management.service;

import com.example.apartment_management.model.Apartment;
import com.example.apartment_management.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    public Apartment getApartmentById(String id) {
        return apartmentRepository.findById(id).orElse(null);
    }

    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    public void deleteApartment(String id) {
        apartmentRepository.deleteById(id);
    }
}
