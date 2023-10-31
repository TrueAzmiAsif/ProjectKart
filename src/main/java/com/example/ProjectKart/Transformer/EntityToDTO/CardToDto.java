package com.example.ProjectKart.Transformer.EntityToDTO;

import com.example.ProjectKart.DTO.ResponseDTO.CardResponse;
import com.example.ProjectKart.Model.Card;

public class CardToDto {
    public static CardResponse cardToDto(Card card,String message){
        String arr[]=card.getNumber().split(" ");
        return CardResponse.builder()
                .message(message)
                .number("XXXX XXXX XXXX "+arr[3])
                .build();
    }
}
