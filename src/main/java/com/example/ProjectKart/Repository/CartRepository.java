package com.example.ProjectKart.Repository;

import com.example.ProjectKart.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
