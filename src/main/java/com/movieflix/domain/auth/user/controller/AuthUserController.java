package com.movieflix.domain.auth.user.controller;


import com.movieflix.domain.auth.user.dto.AuthUserRequest;
import com.movieflix.domain.auth.user.service.AuthUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/user/auth")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping
    public ResponseEntity<String> handler(@Valid @RequestBody AuthUserRequest authUserRequest) {

        System.out.println(authUserService.auth(authUserRequest));
        return ResponseEntity.ok(authUserService.auth(authUserRequest));

    }

}
