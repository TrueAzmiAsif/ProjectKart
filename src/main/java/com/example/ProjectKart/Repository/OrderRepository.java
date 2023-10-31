package com.example.ProjectKart.Repository;

import com.example.ProjectKart.Model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordered,Integer> {
}
