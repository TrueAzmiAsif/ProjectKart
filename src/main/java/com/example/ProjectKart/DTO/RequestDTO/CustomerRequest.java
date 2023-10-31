package com.example.ProjectKart.DTO.RequestDTO;

import com.example.ProjectKart.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {
    String name;
    int contact;
    Gender gender;
    String address;
    String mail;
}
