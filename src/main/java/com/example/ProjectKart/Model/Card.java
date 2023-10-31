package com.example.ProjectKart.Model;

import com.example.ProjectKart.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String number;
    String cvv;
    Date exp;
    @Enumerated(EnumType.STRING)
    CardType type;
    @ManyToOne
    @JoinColumn
    Customer customer;
}
