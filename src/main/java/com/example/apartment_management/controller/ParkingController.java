package com.example.apartment_management.controller;

import com.example.apartment_management.model.Parking;
import com.example.apartment_management.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/parkings")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @GetMapping
    public String listParkings(Model model) {
        model.addAttribute("parkings", parkingService.getAllParkings());
        return "parkings/list";
    }

    @GetMapping("/add")
    public String addParkingForm(Model model) {
        model.addAttribute("parking", new Parking());
        return "parkings/add";
    }

    @PostMapping("/add")
    public String saveParking(@ModelAttribute("parking") Parking parking) {
        parking.setEntryTime(new Date());
        parking.setStatus("In");
        parking.setParkingFee(0);
        parkingService.saveParking(parking);
        return "redirect:/parkings";
    }

    @GetMapping("/checkout/{id}")
    public String checkoutParking(@PathVariable String id) {
        parkingService.checkoutParking(id);
        return "redirect:/parkings";
    }

    @GetMapping("/delete/{id}")
    public String deleteParking(@PathVariable String id) {
        parkingService.deleteParking(id);
        return "redirect:/parkings";
    }
}
