package com.example.ProjectKart.DTO.RequestDTO;

import com.example.ProjectKart.Model.Cart;
import com.example.ProjectKart.Model.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ItemRequest {
    int reqQuantity;
    int productId;
    int custContact;
}
