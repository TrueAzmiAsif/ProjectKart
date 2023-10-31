package com.example.ProjectKart.DTO.ResponseDTO;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class CartResponse {
    int total;
    String customerName;
    List<ItemResponse> items=new ArrayList<>();
}
