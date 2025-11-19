package com.movieflix.domain.auth.controller;


import com.movieflix.config.TokenService;
import com.movieflix.domain.auth.DTO.LoginRequest;
import com.movieflix.domain.auth.DTO.LoginResponse;
import com.movieflix.domain.user.entity.Users;
import com.movieflix.exceptions.usernameOrPasswordInvalidException.UsernameOrPasswordInvalidException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/user")
public class AuthUserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> handler(@Valid @RequestBody LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(
                    request.email(), request.password());

            var authenticate = this.authenticationManager.authenticate(userAndPass);

            var user = (Users) authenticate.getPrincipal();

            var token = this.tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));
        } catch (BadCredentialsException e) {
            throw new UsernameOrPasswordInvalidException("Username or password invalid");
        }

    }

}
