package com.example.demosecurity.controller;

import com.example.demosecurity.model.dto.payloads.request.SignUpForm;
import com.example.demosecurity.model.dto.payloads.response.JwtResponse;
import com.example.demosecurity.model.dto.payloads.response.ResponseMessage;
import com.example.demosecurity.model.entity.AppRole;
import com.example.demosecurity.model.entity.AppUser;
import com.example.demosecurity.service.IRoleService;
import com.example.demosecurity.service.IUserService;
import com.example.demosecurity.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if(userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(new ResponseMessage("The username existed!"), HttpStatus.OK);
        }
        AppUser appUser = new AppUser(signUpForm.getUsername(),passwordEncoder.encode(signUpForm.getPassword()),signUpForm.getFullName(),signUpForm.getRoles());
        userService.save(appUser);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody AppUser appUser) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.createToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AppUser currentUser = userService.findByUsername(appUser.getUsername()).get();
        JwtResponse jwtResponse = new JwtResponse(currentUser.getId(),jwt,userDetails.getUsername(), currentUser.getFullName(), userDetails.getAuthorities());
        return ResponseEntity.ok(jwtResponse);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
