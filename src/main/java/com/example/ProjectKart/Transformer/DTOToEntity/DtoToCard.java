package com.example.ProjectKart.Transformer.DTOToEntity;

import com.example.ProjectKart.DTO.RequestDTO.CardRequest;
import com.example.ProjectKart.Model.Card;
import com.example.ProjectKart.Model.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DtoToCard {
    public static Card dtoToCard(CardRequest cardReq, Customer cust) throws ParseException {
        return Card.builder()
                .number(cardReq.getNumber())
                .type(cardReq.getType())
                .cvv(cardReq.getCvv())
                .exp(new SimpleDateFormat("dd-MM-yyyy").parse(cardReq.getExp()))
                .customer(cust)
                .build();
    }
}
