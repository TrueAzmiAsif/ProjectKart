package com.example.ProjectKart.Repository;

import com.example.ProjectKart.DTO.ResponseDTO.ProductResponse;
import com.example.ProjectKart.Enum.Category;
import com.example.ProjectKart.Model.Product;
import com.example.ProjectKart.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findByNameAndCategory(String name, Category cat);
    public List<Product> findByCategory(Category cat);
}
