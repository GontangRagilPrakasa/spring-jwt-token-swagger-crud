package com.tutorial.jwtauthentication.controller;

import com.tutorial.jwtauthentication.component.TokenProvider;
import com.tutorial.jwtauthentication.dto.LoginRequest;
import com.tutorial.jwtauthentication.dto.LoginResponse;
import com.tutorial.jwtauthentication.model.Users;
import com.tutorial.jwtauthentication.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("userDetailsService")
    private UserService userService;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request)
    {
        Users users = (Users) userService.loadUserByUsername(request.getUsername());
        log.info("User :: {}", users);

        if(!passwordEncoder.matches(request.getPassword(), users.getPassword())) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);

        return ResponseEntity.ok(new LoginResponse(token));
    }


}
