package com.example.ProjectKart.Transformer.EntityToDTO;

import com.example.ProjectKart.DTO.ResponseDTO.CustomerResponse;
import com.example.ProjectKart.Model.Customer;
import lombok.Builder;

public class CustomerToDTO {
    public static CustomerResponse customerToDTO(Customer cust){
        return CustomerResponse.builder()
                .name(cust.getName())
                .message("Thank you for registering with us.")
                .build();
    }
}
