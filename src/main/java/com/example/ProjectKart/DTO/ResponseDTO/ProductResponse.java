package com.example.ProjectKart.DTO.ResponseDTO;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class ProductResponse {
    String name;
    String category;
    String message;
    int quantity;
}
