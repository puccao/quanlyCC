package com.example.apartment_management.controller;

import com.example.apartment_management.model.Household;
import com.example.apartment_management.service.ApartmentService;
import com.example.apartment_management.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/households")
public class HouseholdController {
    @Autowired
    private HouseholdService householdService;

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public String listHouseholds(Model model) {
        model.addAttribute("households", householdService.getAllHouseholds());
        return "households/list";
    }

    @GetMapping("/add")
    public String addHouseholdForm(Model model) {
        model.addAttribute("household", new Household());
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "households/add";
    }

    @PostMapping("/add")
    public String saveHousehold(@ModelAttribute("household") Household household) {
        householdService.saveHousehold(household);
        return "redirect:/households";
    }

    @GetMapping("/edit/{id}")
    public String editHouseholdForm(@PathVariable String id, Model model) {
        Household household = householdService.getHouseholdById(id);
        model.addAttribute("household", household);
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "households/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateHousehold(@PathVariable String id, @ModelAttribute("household") Household household) {
        household.setId(id);
        householdService.saveHousehold(household);
        return "redirect:/households";
    }

    @GetMapping("/delete/{id}")
    public String deleteHousehold(@PathVariable String id) {
        householdService.deleteHousehold(id);
        return "redirect:/households";
    }
}
