package com.example.ProjectKart.Transformer.EntityToDTO;

import com.example.ProjectKart.DTO.ResponseDTO.ItemResponse;
import com.example.ProjectKart.DTO.ResponseDTO.OrderResponse;
import com.example.ProjectKart.Model.Item;
import com.example.ProjectKart.Model.Ordered;

import java.util.ArrayList;
import java.util.List;


public class OrderToDto {
    public static OrderResponse orderToDto(Ordered order){
        List<ItemResponse> itemResp=new ArrayList<>();
        for(Item x: order.getItems()){
            itemResp.add(ItemtoDto.itemToDto(x));
        }
        return OrderResponse.builder()
                .name(order.getCustomer().getName())
                .OrderNumber(order.getOrderNumber())
                .cardUsed(order.getCardUsed())
                .quantity(order.getQuantity())
                .total(order.getTotal())
                .orderdate(order.getOrderDate())
                .item(itemResp)
                .build();
    }
}
