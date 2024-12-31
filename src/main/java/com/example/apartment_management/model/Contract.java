package com.example.apartment_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "contracts")
public class Contract {
    @Id
    private String id;
    private String tenantName;   // Tên người thuê
    private String tenantIdCard; // CMND/CCCD người thuê
    private String apartmentId;  // ID căn hộ
    private LocalDate startDate; // Ngày bắt đầu thuê
    private LocalDate endDate;   // Ngày kết thúc thuê
    private double rentPrice;    // Giá thuê
    private String status;       // Trạng thái hợp đồng (Active, Expired, Terminated)
}
