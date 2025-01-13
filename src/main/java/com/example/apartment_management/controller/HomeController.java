package com.example.apartment_management.controller;

import com.example.apartment_management.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private ApartmentService apartmentService;
    

    // Trang chủ, sẽ hiển thị trang index.html
    @RequestMapping("/")
    public String home(Model model) {
        // Lấy danh sách tất cả các căn hộ
        long totalApartments = apartmentService.getAllApartments().size();
        
        // Truyền dữ liệu tổng số căn hộ vào model
        model.addAttribute("totalApartments", totalApartments);

        return "index";  // Trả về trang index.html nếu đang dùng Thymeleaf
    }
}
