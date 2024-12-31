package com.example.apartment_management.service;

import com.example.apartment_management.model.Parking;
import com.example.apartment_management.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    public List<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }

    public Parking getParkingById(String id) {
        return parkingRepository.findById(id).orElse(null);
    }

    public List<Parking> getActiveParkings() {
        return parkingRepository.findByStatus("In");
    }

    public Parking saveParking(Parking parking) {
        return parkingRepository.save(parking);
    }

    public void deleteParking(String id) {
        parkingRepository.deleteById(id);
    }

    public void checkoutParking(String id) {
        Parking parking = parkingRepository.findById(id).orElse(null);
        if (parking != null && "In".equals(parking.getStatus())) {
            parking.setExitTime(new Date());
            long duration = (parking.getExitTime().getTime() - parking.getEntryTime().getTime()) / (1000 * 60 * 60);
            parking.setParkingFee(duration * 5000); // Tính phí 5000 đồng/giờ
            parking.setStatus("Out");
            parkingRepository.save(parking);
        }
    }
}
