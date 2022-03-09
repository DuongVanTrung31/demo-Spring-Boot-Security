package com.example.demosecurity.service;

import com.example.demosecurity.model.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends UserDetailsService,IGeneralService<AppUser> {
    Boolean existsByUsername(String username);
    Optional<AppUser> findByUsername(String username);
}
