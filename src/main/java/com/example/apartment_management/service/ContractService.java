package com.example.apartment_management.service;

import com.example.apartment_management.model.Contract;
import com.example.apartment_management.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public Contract getContractById(String id) {
        return contractRepository.findById(id).orElse(null);
    }

    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteContract(String id) {
        contractRepository.deleteById(id);
    }
}
