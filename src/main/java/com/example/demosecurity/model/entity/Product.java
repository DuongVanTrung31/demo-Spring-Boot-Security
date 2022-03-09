package com.example.demosecurity.model.entity;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name product should be not empty")
    private String name;
    private int price;
    private String description;
    private String image;

    @Transient
    private MultipartFile file;
    @ManyToOne
    private Category category;
}
