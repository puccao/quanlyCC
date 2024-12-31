package com.example.apartment_management.controller;

import com.example.apartment_management.model.ApartmentService;
import com.example.apartment_management.service.ApartmentServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/services")
public class ApartmentServiceController {

    @Autowired
    private ApartmentServiceService apartmentServiceService;

    // Hiển thị danh sách các dịch vụ
    @GetMapping
    public String listServices(Model model) {
        model.addAttribute("services", apartmentServiceService.getAllServices());
        return "services/list";
    }

    // Form thêm dịch vụ mới
    @GetMapping("/add")
    public String addServiceForm(Model model) {
        model.addAttribute("service", new ApartmentService());
        return "services/add";
    }

    // Lưu dịch vụ mới
    @PostMapping("/add")
    public String saveService(@ModelAttribute("service") ApartmentService apartmentService) {
        // Đặt trạng thái mặc định cho dịch vụ là 'Active'
        apartmentService.setStatus("Active");
        apartmentServiceService.saveService(apartmentService); // Lưu dịch vụ mới
        return "redirect:/services"; // Quay lại danh sách dịch vụ
    }

    // Form sửa dịch vụ
    @GetMapping("/edit/{id}")
    public String editServiceForm(@PathVariable String id, Model model) {
        ApartmentService apartmentService = apartmentServiceService.getServiceById(id);
        if (apartmentService == null) {
            // Nếu dịch vụ không tồn tại, chuyển hướng về trang danh sách
            return "redirect:/services";
        }
        model.addAttribute("service", apartmentService);
        return "services/edit"; // Trả về trang chỉnh sửa dịch vụ
    }

    // Cập nhật dịch vụ
    @PostMapping("/edit/{id}")
    public String updateService(@PathVariable String id, @ModelAttribute("service") ApartmentService apartmentService) {
        // Đảm bảo ID của dịch vụ được giữ nguyên khi cập nhật
        apartmentService.setId(id);
        apartmentServiceService.saveService(apartmentService); // Lưu dịch vụ đã cập nhật
        return "redirect:/services"; // Quay lại danh sách dịch vụ
    }

    // Xóa dịch vụ
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable String id) {
        apartmentServiceService.deleteService(id); // Xóa dịch vụ theo ID
        return "redirect:/services"; // Quay lại danh sách dịch vụ
    }
}
