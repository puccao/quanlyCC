package com.example.apartment_management.controller;

import com.example.apartment_management.model.Apartment;
import com.example.apartment_management.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/apartments")
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public String listApartments(Model model) {
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "apartments/list";
    }

    @GetMapping("/add")
    public String addApartmentForm(Model model) {
        model.addAttribute("apartment", new Apartment());
        return "apartments/add";
    }

    @PostMapping("/add")
    public String saveApartment(@ModelAttribute("apartment") Apartment apartment) {
        apartmentService.saveApartment(apartment);
        return "redirect:/apartments";
    }

    @GetMapping("/edit/{id}")
    public String editApartmentForm(@PathVariable String id, Model model) {
        Apartment apartment = apartmentService.getApartmentById(id);
        model.addAttribute("apartment", apartment);
        return "apartments/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateApartment(@PathVariable String id, @ModelAttribute("apartment") Apartment apartment) {
        apartment.setId(id);
        apartmentService.saveApartment(apartment);
        return "redirect:/apartments";
    }

    @GetMapping("/delete/{id}")
    public String deleteApartment(@PathVariable String id) {
        apartmentService.deleteApartment(id);
        return "redirect:/apartments";
    }
}
