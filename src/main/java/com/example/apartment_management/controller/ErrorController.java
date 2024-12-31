package com.example.apartment_management.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ErrorController {
    @RequestMapping("/custom-error")
    public String handleError() {
        // Trả về trang error.html
        return "error";
    }
}
