package com.example.ProjectKart.DTO.ResponseDTO;

import com.example.ProjectKart.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponse {
    String number;
    String message;
}
