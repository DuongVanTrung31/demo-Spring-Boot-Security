package com.example.demosecurity.model.dto.payloads.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


@AllArgsConstructor
@Data
public class JwtResponse {
    private Long id;
    private String token;
    private final String type = "Bearer";
    private String userName;
    private String fullName;
    private Collection<? extends GrantedAuthority> roles;

}
