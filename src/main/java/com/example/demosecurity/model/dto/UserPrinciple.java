package com.example.demosecurity.model.dto;

import com.example.demosecurity.model.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Data
public class UserPrinciple implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private Collection<? extends  GrantedAuthority> roles;

    public static UserPrinciple build(AppUser appUser) {
        List<GrantedAuthority> authorities = appUser.getRole().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName())
        ).collect(Collectors.toList());
        return new UserPrinciple(
                appUser.getId(),
                appUser.getUsername(),
                appUser.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
