package com.example.ProjectKart.Service;

import com.example.ProjectKart.DTO.RequestDTO.SellerRequest;
import com.example.ProjectKart.DTO.ResponseDTO.SellerResponse;

public interface SellerService {
    public SellerResponse add(SellerRequest dto);
}
