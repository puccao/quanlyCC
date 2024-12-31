package com.example.apartment_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "parkings")
public class Parking {
    @Id
    private String id;
    private String vehicleNumber;  // Biển số xe
    private String vehicleType;    // Loại xe (Xe máy, ô tô)
    private String ownerName;      // Chủ sở hữu
    private String apartmentId;    // Căn hộ liên quan
    private Date entryTime;        // Thời gian vào
    private Date exitTime;         // Thời gian ra
    private double parkingFee;     // Phí gửi xe
    private String status;         // Trạng thái (In/Out)
}
