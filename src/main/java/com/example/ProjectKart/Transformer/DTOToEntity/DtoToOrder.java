package com.example.ProjectKart.Transformer.DTOToEntity;


import com.example.ProjectKart.DTO.RequestDTO.OrderRequest;
import com.example.ProjectKart.Model.*;

import java.util.List;
import java.util.UUID;

public class DtoToOrder {
    public static Ordered DtoToOrder(OrderRequest orderReq, Product pro, Card card, List<Item> items, Customer cust){
        String cardUsed="XXXX XXXX XXXX ";
        String temp[]=card.getNumber().split(" ");
        cardUsed+=temp[3];
        return Ordered.builder()
                .orderNumber(UUID.randomUUID().toString())
                .quantity(orderReq.getQuantity())
                .cardUsed(cardUsed)
                .total(pro.getPrice()* orderReq.getQuantity())
                .items(items)
                .customer(cust)
                .build();
    }
}
