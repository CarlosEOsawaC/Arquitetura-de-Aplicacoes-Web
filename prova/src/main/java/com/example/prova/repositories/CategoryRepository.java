package com.example.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prova.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
