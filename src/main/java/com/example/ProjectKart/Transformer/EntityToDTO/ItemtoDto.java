package com.example.ProjectKart.Transformer.EntityToDTO;

import com.example.ProjectKart.DTO.ResponseDTO.ItemResponse;
import com.example.ProjectKart.Model.Item;

public class ItemtoDto {
    public static ItemResponse itemToDto(Item item){
        return ItemResponse.builder()
                .proName(item.getProduct().getName())
                .proPrice(item.getProduct().getPrice())
                .requiredQuantity(item.getReqQuantity())
                .totalCostOfItem(item.getReqQuantity()*item.getProduct().getPrice())
                .sellerName(item.getProduct().getSeller().getName())
                .build();
    }
}
