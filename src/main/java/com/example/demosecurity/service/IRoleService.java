package com.example.demosecurity.service;

import com.example.demosecurity.model.entity.AppRole;

import javax.management.relation.Role;

public interface IRoleService extends IGeneralService<AppRole> {
    AppRole findByRoleName (String roleName);
}
