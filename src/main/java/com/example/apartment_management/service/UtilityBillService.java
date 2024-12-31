package com.example.apartment_management.service;

import com.example.apartment_management.model.UtilityBill;
import com.example.apartment_management.repository.UtilityBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilityBillService {
    @Autowired
    private UtilityBillRepository utilityBillRepository;

    public List<UtilityBill> getAllUtilityBills() {
        return utilityBillRepository.findAll();
    }

    public UtilityBill getUtilityBillById(String id) {
        return utilityBillRepository.findById(id).orElse(null);
    }

    public List<UtilityBill> getUtilityBillsByApartment(String apartmentId) {
        return utilityBillRepository.findByApartmentId(apartmentId);
    }

    public UtilityBill saveUtilityBill(UtilityBill utilityBill) {
        return utilityBillRepository.save(utilityBill);
    }

    public void deleteUtilityBill(String id) {
        utilityBillRepository.deleteById(id);
    }
}
