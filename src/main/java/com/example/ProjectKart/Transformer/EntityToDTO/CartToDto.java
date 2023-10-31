package com.example.ProjectKart.Transformer.EntityToDTO;

import com.example.ProjectKart.DTO.ResponseDTO.CartResponse;
import com.example.ProjectKart.DTO.ResponseDTO.ItemResponse;
import com.example.ProjectKart.Model.Cart;
import com.example.ProjectKart.Model.Item;

import java.util.List;

public class CartToDto {
    public static CartResponse cartToDto(Cart cart, Item item, List<ItemResponse> itemResp){
        System.out.println(cart.getCartTotal());
        CartResponse cartResp= CartResponse.builder()
                .customerName(cart.getCustomer().getName())
                .total(cart.getCartTotal())
                .items(itemResp)
                .build();
        return cartResp;
    }
}
