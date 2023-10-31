package com.example.ProjectKart.DTO.RequestDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class OrderRequest {
    String cardNumber;
    String cvv;
    int quantity;
    int customerContact;
    int productId;
}
