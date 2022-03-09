package com.example.demosecurity.service;

import com.example.demosecurity.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product>{
    Iterable<Product> findAllByNameContaining(String name);
    Iterable<Product> findAllByCategory_Id(Long id);
    Page<Product> showPage(Pageable pageable);
}
