package com.example.ativ5.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ativ5.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
    List<Produto> findByName(String name);
    List<Produto> findByDescription(String description);
}