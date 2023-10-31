package com.example.ProjectKart.Transformer.DTOToEntity;

import com.example.ProjectKart.DTO.RequestDTO.SellerRequest;
import com.example.ProjectKart.Model.Seller;

public class DtoToSeller {
    public static Seller dtoToSeller(SellerRequest dto){
        return Seller.builder()
                .name(dto.getName())
                .contact(dto.getContact())
                .mail(dto.getMail())
                .build();
    }
}
