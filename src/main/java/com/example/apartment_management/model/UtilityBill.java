package com.example.apartment_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "utility_bills")
public class UtilityBill {
    @Id
    private String id;
    private String apartmentId;          // ID căn hộ
    private double electricityUsage;     // Số điện tiêu thụ
    private double waterUsage;           // Số nước tiêu thụ
    private double electricityCost;      // Chi phí điện
    private double waterCost;            // Chi phí nước
    private double totalCost;            // Tổng chi phí
    private Date billingDate;            // Ngày lập hóa đơn
    private String status;               // Trạng thái (Paid/Unpaid)
}
