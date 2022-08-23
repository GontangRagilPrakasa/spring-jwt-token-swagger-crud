package com.tutorial.jwtauthentication.service;

import com.tutorial.jwtauthentication.repository.UserRepository;
import com.tutorial.jwtauthentication.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Object> getAll(Object principal)
    {
        return ResponseUtil.build(
                false,
                HttpStatus.OK.value(),
                "Tidak Berhasil Ditemukan",
                principal,
                HttpStatus.OK
        );
    }
}
