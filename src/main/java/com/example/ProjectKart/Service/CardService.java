package com.example.ProjectKart.Service;

import com.example.ProjectKart.DTO.RequestDTO.CardRequest;
import com.example.ProjectKart.DTO.ResponseDTO.CardResponse;
import com.example.ProjectKart.Exception.CustomerNotFoundException;

import java.text.ParseException;

public interface CardService {
    public CardResponse add(CardRequest cardReq) throws ParseException, CustomerNotFoundException;
}
