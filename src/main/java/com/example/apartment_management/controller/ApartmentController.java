package com.example.apartment_management.controller;

import com.example.apartment_management.model.Apartment;
import com.example.apartment_management.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/apartments")
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;

    // Trang danh sách căn hộ
    @GetMapping
    public String listApartments(Model model) {
        // Lấy danh sách tất cả các căn hộ
        List<Apartment> apartments = apartmentService.getAllApartments();
        model.addAttribute("apartments", apartments);

        return "apartments/list"; // Chuyển hướng tới giao diện "list.html"
    }

    // Thêm căn hộ
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

    // Chỉnh sửa căn hộ
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

    // Xóa căn hộ
    @GetMapping("/delete/{id}")
    public String deleteApartment(@PathVariable String id) {
        apartmentService.deleteApartment(id);
        return "redirect:/apartments";
    }
}
