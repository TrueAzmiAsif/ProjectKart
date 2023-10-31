package com.example.ProjectKart.Repository;

import com.example.ProjectKart.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    public Seller findByContact(int contact);
}
