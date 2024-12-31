package com.example.apartment_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "households")
public class Household {
    @Id
    private String id;
    private String householdName;        // Tên hộ gia đình
    private String apartmentId;          // ID căn hộ
    private List<Member> members;        // Danh sách thành viên
    private String contactNumber;        // Số điện thoại liên hệ
}

@Data
class Member {
    private String name;                 // Tên thành viên
    private int age;                     // Tuổi
    private String relation;             // Quan hệ với chủ hộ
}
