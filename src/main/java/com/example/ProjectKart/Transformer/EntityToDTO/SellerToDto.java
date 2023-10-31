package com.example.ProjectKart.Transformer.EntityToDTO;

import com.example.ProjectKart.DTO.ResponseDTO.SellerResponse;
import com.example.ProjectKart.Model.Seller;

public class SellerToDto {
    public static SellerResponse sellerToDto(Seller seller){
        return SellerResponse.builder()
                .name(seller.getName())
                .message("Thank you! for registering yourself with us!")
                .build();
    }
}
