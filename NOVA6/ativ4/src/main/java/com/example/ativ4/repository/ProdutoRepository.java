package com.example.ativ4.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.example.ativ4.model.Produto;

@Repository 
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}