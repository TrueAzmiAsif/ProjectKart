package com.example.ProjectKart.Repository;

import com.example.ProjectKart.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
    public Card findByNumber(String number);
}
