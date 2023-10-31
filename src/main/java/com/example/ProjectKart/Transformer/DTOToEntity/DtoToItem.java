package com.example.ProjectKart.Transformer.DTOToEntity;

import com.example.ProjectKart.DTO.RequestDTO.ItemRequest;
import com.example.ProjectKart.Model.Cart;
import com.example.ProjectKart.Model.Item;
import com.example.ProjectKart.Model.Product;

public class DtoToItem {
    public static Item dtoToItem(ItemRequest itemReq, Cart cart, Product pro){
        return Item.builder()
//                .cart(cart)
//                .product(pro)
                .reqQuantity(itemReq.getReqQuantity())
                .build();
    }
}
