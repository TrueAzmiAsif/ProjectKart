package com.example.ProjectKart.Transformer.DTOToEntity;

import com.example.ProjectKart.DTO.RequestDTO.CustomerRequest;
import com.example.ProjectKart.Model.Customer;

public class DTOToCustomer {
    public static Customer dTOToCustomer(CustomerRequest dto){
        return Customer.builder()
                .name(dto.getName())
                .number(dto.getContact())
                .mail(dto.getMail())
                .gender(dto.getGender())
                .address(dto.getAddress())
                .build();
    }
}
