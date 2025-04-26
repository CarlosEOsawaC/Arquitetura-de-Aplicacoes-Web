package com.example.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prova.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
