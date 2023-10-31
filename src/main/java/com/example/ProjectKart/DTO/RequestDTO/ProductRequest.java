package com.example.ProjectKart.DTO.RequestDTO;

import com.example.ProjectKart.Enum.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ProductRequest {
    String name;
    Category category;
    int price;
    int quantity;
    int SellerContact;
}
