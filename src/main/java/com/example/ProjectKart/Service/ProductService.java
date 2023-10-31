package com.example.ProjectKart.Service;

import com.example.ProjectKart.DTO.RequestDTO.ProductRequest;
import com.example.ProjectKart.DTO.ResponseDTO.ProductResponse;
import com.example.ProjectKart.Enum.Category;
import com.example.ProjectKart.Exception.SellerNotRegisteredException;

import java.util.List;

public interface ProductService {
    public ProductResponse add(ProductRequest dto)throws SellerNotRegisteredException;

    public List<ProductResponse> findByCategory(Category cat);
}
