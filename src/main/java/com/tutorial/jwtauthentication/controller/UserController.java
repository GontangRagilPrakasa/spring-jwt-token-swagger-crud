package com.tutorial.jwtauthentication.controller;

import com.tutorial.jwtauthentication.dto.PingResponse;
import com.tutorial.jwtauthentication.service.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class UserController {

    @Autowired
    private AuthServices authServices;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/v1/admin")
    public ResponseEntity<Object> adminPing() {
        return ResponseEntity.ok().body(PingResponse.builder()
                .message("Only admin can view this resource!")
                .build()
        );
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/v1/user")
    public ResponseEntity<Object> userPing() {
        return ResponseEntity.ok().body(PingResponse.builder()
                .message("Any user can view this response")
                .build()
        );
    }

    @GetMapping(value = "/me")
    public ResponseEntity<Object> me(Principal principal)
    {
        return authServices.getAll(principal);
    }
}
