package com.movieflix.domain.user.controller;


import com.movieflix.domain.user.dto.UserRequest;
import com.movieflix.domain.user.dto.UserResponse;
import com.movieflix.domain.user.entity.User;
import com.movieflix.domain.user.mapper.UserMapper;
import com.movieflix.domain.user.service.RegisterUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/user")
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping
    @Tag(
            name = "Register user",
            description = "Endpoint for register a user"
    )
    public ResponseEntity<UserResponse> handler(@Valid @RequestBody UserRequest userRequest) {

        User userRegistered = registerUserService.register(UserMapper.toUser(userRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(userRegistered));

    }
}
