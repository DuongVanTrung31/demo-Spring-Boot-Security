package com.example.demosecurity.service.impl;

import com.example.demosecurity.model.entity.AppRole;
import com.example.demosecurity.repo.AppRoleRepository;
import com.example.demosecurity.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private AppRoleRepository roleRepository;


    @Override
    public Iterable<AppRole> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public AppRole save(AppRole appRole) {
        return roleRepository.save(appRole);
    }

    @Override
    public void remove(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public AppRole findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
