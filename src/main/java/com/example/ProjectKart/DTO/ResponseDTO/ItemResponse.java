package com.example.ProjectKart.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class ItemResponse {
    String proName;
    int proPrice;
    int requiredQuantity;
    int totalCostOfItem;
    String sellerName;
}
