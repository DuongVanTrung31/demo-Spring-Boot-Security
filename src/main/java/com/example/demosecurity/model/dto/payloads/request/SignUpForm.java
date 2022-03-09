package com.example.demosecurity.model.dto.payloads.request;

import com.example.demosecurity.model.entity.AppRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class SignUpForm {
    private String fullName;
    private String username;
    private String password;
    private Set<AppRole> roles;
}
