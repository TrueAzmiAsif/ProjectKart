package com.example.ProjectKart.Service;

import com.example.ProjectKart.DTO.RequestDTO.CustomerRequest;
import com.example.ProjectKart.DTO.ResponseDTO.CustomerResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    CustomerResponse add(CustomerRequest cReqDTO);
}
