package com.example.ProjectKart.Transformer.DTOToEntity;

import com.example.ProjectKart.DTO.RequestDTO.OrderRequest;
import com.example.ProjectKart.Model.Item;
import com.example.ProjectKart.Model.Product;

public class OrderDTOToItemEntity {
    public static Item orderDTOToItemEntity(OrderRequest orderReq, Product prod){
        return Item.builder()
                .reqQuantity(orderReq.getQuantity())
                .product(prod)
                .build();
    }
}
