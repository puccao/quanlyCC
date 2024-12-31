package com.example.apartment_management.controller;

import com.example.apartment_management.model.Contract;
import com.example.apartment_management.service.ApartmentService;
import com.example.apartment_management.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public String listContracts(Model model) {
        model.addAttribute("contracts", contractService.getAllContracts());
        return "contracts/list";
    }

    @GetMapping("/add")
    public String addContractForm(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("apartments", apartmentService.getAllApartments()); // Cung cấp danh sách căn hộ
        return "contracts/add";
    }

    @PostMapping("/add")
    public String saveContract(@ModelAttribute("contract") Contract contract) {
        contract.setStatus("Active");
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/edit/{id}")
    public String editContractForm(@PathVariable String id, Model model) {
        Contract contract = contractService.getContractById(id);
        model.addAttribute("contract", contract);
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "contracts/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateContract(@PathVariable String id, @ModelAttribute("contract") Contract contract) {
        contract.setId(id);
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable String id) {
        contractService.deleteContract(id);
        return "redirect:/contracts";
    }
}
