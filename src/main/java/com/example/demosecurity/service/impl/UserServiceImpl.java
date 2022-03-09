package com.example.demosecurity.service.impl;

import com.example.demosecurity.model.dto.UserPrinciple;
import com.example.demosecurity.model.entity.AppUser;
import com.example.demosecurity.repo.AppUserRepository;
import com.example.demosecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userOptional = appUserRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(userOptional.get());

    }

    @Override
    public Iterable<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepository.findById(id);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public void remove(Long id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return appUserRepository.existsByUsername(username);
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
