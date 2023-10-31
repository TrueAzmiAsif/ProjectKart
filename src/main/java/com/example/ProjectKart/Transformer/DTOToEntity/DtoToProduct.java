package com.example.ProjectKart.Transformer.DTOToEntity;

import com.example.ProjectKart.DTO.RequestDTO.ProductRequest;
import com.example.ProjectKart.Enum.ProductStatus;
import com.example.ProjectKart.Enum.Status;
import com.example.ProjectKart.Model.Product;
import com.example.ProjectKart.Model.Seller;

public class DtoToProduct {
    public static Product dtoToProduct(ProductRequest dto, Seller seller){
        return Product.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .status(ProductStatus.IN_STOCK)
                .seller(seller)
                .build();
    }
}
