package com.example.apartment_management.service;

import com.example.apartment_management.model.ApartmentService;
import com.example.apartment_management.repository.ApartmentServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Thay @ApartmentService thành @Service để đánh dấu lớp này là service của Spring
public class ApartmentServiceService {

    @Autowired
    private ApartmentServiceRepository serviceRepository;

    // Lấy danh sách tất cả các dịch vụ
    public List<ApartmentService> getAllServices() {
        return serviceRepository.findAll();
    }

    // Lấy dịch vụ theo ID
    public ApartmentService getServiceById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    // Lưu dịch vụ mới hoặc cập nhật dịch vụ
    public ApartmentService saveService(ApartmentService apartmentService) {
        return serviceRepository.save(apartmentService);
    }

    // Xóa dịch vụ theo ID
    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }
}
