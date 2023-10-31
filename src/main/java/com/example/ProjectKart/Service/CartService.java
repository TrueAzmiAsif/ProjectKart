package com.example.ProjectKart.Service;

import com.example.ProjectKart.DTO.RequestDTO.ItemRequest;
import com.example.ProjectKart.DTO.ResponseDTO.CartResponse;
import com.example.ProjectKart.Model.Cart;
import com.example.ProjectKart.Model.Customer;
import com.example.ProjectKart.Model.Item;

public interface CartService {
    public Cart create(Customer cust);

    CartResponse addItemToCart(Item item, ItemRequest itemReq);
}
