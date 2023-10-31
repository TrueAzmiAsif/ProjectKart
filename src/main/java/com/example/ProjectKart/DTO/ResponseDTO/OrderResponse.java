package com.example.ProjectKart.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class OrderResponse {
    String name;
    String OrderNumber;
    int quantity;
    int total;
    Date orderdate;
    String cardUsed;
    List<ItemResponse> item=new ArrayList<>();
}
