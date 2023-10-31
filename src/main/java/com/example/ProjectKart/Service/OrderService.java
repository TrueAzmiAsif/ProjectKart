package com.example.ProjectKart.Service;

import com.example.ProjectKart.DTO.RequestDTO.OrderRequest;
import com.example.ProjectKart.DTO.ResponseDTO.OrderResponse;
import com.example.ProjectKart.Exception.CustomerNotFoundException;
import com.example.ProjectKart.Exception.InvalidCardException;
import com.example.ProjectKart.Exception.ProductNotFoundException;
import com.example.ProjectKart.Exception.StockShortageException;

public interface OrderService {
    public OrderResponse order(OrderRequest oderReq) throws CustomerNotFoundException, ProductNotFoundException, InvalidCardException, StockShortageException;
}
