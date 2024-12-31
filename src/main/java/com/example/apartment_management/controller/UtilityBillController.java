package com.example.apartment_management.controller;

import com.example.apartment_management.model.UtilityBill;
import com.example.apartment_management.service.UtilityBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/utility-bills")
public class UtilityBillController {
    @Autowired
    private UtilityBillService utilityBillService;

    @GetMapping
    public String listUtilityBills(Model model) {
        model.addAttribute("utilityBills", utilityBillService.getAllUtilityBills());
        return "utility-bills/list";
    }

    @GetMapping("/add")
    public String addUtilityBillForm(Model model) {
        model.addAttribute("utilityBill", new UtilityBill());
        return "utility-bills/add";
    }

    @PostMapping("/add")
    public String saveUtilityBill(@ModelAttribute("utilityBill") UtilityBill utilityBill) {
        utilityBill.setBillingDate(new Date());
        utilityBill.setTotalCost(utilityBill.getElectricityCost() + utilityBill.getWaterCost());
        utilityBill.setStatus("Unpaid");
        utilityBillService.saveUtilityBill(utilityBill);
        return "redirect:/utility-bills";
    }

    @GetMapping("/edit/{id}")
    public String editUtilityBillForm(@PathVariable String id, Model model) {
        UtilityBill utilityBill = utilityBillService.getUtilityBillById(id);
        model.addAttribute("utilityBill", utilityBill);
        return "utility-bills/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateUtilityBill(@PathVariable String id, @ModelAttribute("utilityBill") UtilityBill utilityBill) {
        utilityBill.setId(id);
        utilityBill.setTotalCost(utilityBill.getElectricityCost() + utilityBill.getWaterCost());
        utilityBillService.saveUtilityBill(utilityBill);
        return "redirect:/utility-bills";
    }

    @GetMapping("/delete/{id}")
    public String deleteUtilityBill(@PathVariable String id) {
        utilityBillService.deleteUtilityBill(id);
        return "redirect:/utility-bills";
    }

    @GetMapping("/pay/{id}")
    public String payUtilityBill(@PathVariable String id) {
        UtilityBill utilityBill = utilityBillService.getUtilityBillById(id);
        if (utilityBill != null) {
            utilityBill.setStatus("Paid");
            utilityBillService.saveUtilityBill(utilityBill);
        }
        return "redirect:/utility-bills";
    }
}
