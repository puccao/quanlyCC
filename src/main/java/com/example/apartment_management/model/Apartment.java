package com.example.apartment_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "apartments")
public class Apartment {
    @Id
    private String id;
    private String name;  // Tên căn hộ
    private int floor;    // Tầng
    private int rooms;    // Số phòng
    private double area;  // Diện tích
    private boolean isAvailable; // Trạng thái có sẵn hay không

    // Getter và Setter cho các trường này
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }
    
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}


