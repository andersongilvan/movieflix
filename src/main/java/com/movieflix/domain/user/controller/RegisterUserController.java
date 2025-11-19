package com.movieflix.domain.user.controller;


import com.movieflix.domain.user.DTO.UserRequest;
import com.movieflix.domain.user.DTO.UserResponse;
import com.movieflix.domain.user.mapper.UserMapper;
import com.movieflix.domain.user.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/register")
    public ResponseEntity<UserResponse> handler(@RequestBody UserRequest request) {

        var user = UserMapper.toUser(request);

        var result = this.registerUserService.execute(user);

        return ResponseEntity.ok(UserMapper.toUserResponse(result));

    }

}
