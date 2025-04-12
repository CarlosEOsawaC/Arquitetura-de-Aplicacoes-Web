package com.example.ativ4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ativ4.model.Produto;
import com.example.ativ4.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository; 

    public List<Produto> findAll() {
        
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto model) {
        return produtoRepository.save(model);
    }

    public boolean deleteById(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }   
    }

    public Optional<Produto> update(Long id, Produto updatedModel) {
        return produtoRepository.findById(id).map(existingModel -> {
            existingModel.setName(updatedModel.getName());
            existingModel.setDescription(updatedModel.getDescription()); 
            return produtoRepository.save(existingModel); 
        });
    }
}
