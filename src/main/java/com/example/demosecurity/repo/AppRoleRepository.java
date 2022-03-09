package com.example.demosecurity.repo;

import com.example.demosecurity.model.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName (String roleName);
}
