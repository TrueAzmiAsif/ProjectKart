package com.example.ProjectKart.Transformer.EntityToDTO;

import com.example.ProjectKart.DTO.ResponseDTO.ProductResponse;
import com.example.ProjectKart.Model.Product;

public class ProductToDto {
    public static ProductResponse productToDto(Product pro, String message){
        return ProductResponse.builder()
                .name(pro.getName())
                .category(pro.getCategory().toString())
                .message(message)
                .quantity(pro.getQuantity())
                .build();
    }
}
