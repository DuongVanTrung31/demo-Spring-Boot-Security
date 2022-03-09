package com.example.demosecurity.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role")
public class AppRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
}
