package com.example.demosecurity.repo;

import com.example.demosecurity.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Iterable<Product> findAllByNameContaining(String name);
    Iterable<Product> findAllByCategory_Id(Long id);
}
