package com.example.ProjectKart.DTO.RequestDTO;

import com.example.ProjectKart.Enum.CardType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CardRequest {
    String number;
    String cvv;
    String exp;
    CardType type;
    int contact;
}
