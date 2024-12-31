package com.example.apartment_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // Trang chủ, sẽ hiển thị trang index.html
    @RequestMapping("/")
    public String home() {
        return "index";  // Trả về trang index.html nếu đang dùng Thymeleaf
    }

}
