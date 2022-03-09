package com.example.demosecurity.service.impl;

import com.example.demosecurity.model.entity.Product;
import com.example.demosecurity.repo.ProductRepository;
import com.example.demosecurity.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByCategory_Id(Long id) {
        return productRepository.findAllByCategory_Id(id);
    }

    @Override
    public Page<Product> showPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
