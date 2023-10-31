package com.example.ProjectKart.Service;

import com.example.ProjectKart.DTO.RequestDTO.ItemRequest;
import com.example.ProjectKart.Exception.CustomerNotFoundException;
import com.example.ProjectKart.Exception.ProductIsOutOfStockException;
import com.example.ProjectKart.Exception.ProductNotFoundException;
import com.example.ProjectKart.Exception.StockShortageException;
import com.example.ProjectKart.Model.Item;

public interface ItemService {
    public Item addItemToCart(ItemRequest itemReq)throws CustomerNotFoundException, ProductNotFoundException, ProductIsOutOfStockException, StockShortageException;
}
