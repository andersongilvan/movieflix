package com.movieflix.domain.auth.user.service;


import com.movieflix.domain.auth.user.dto.AuthUserRequest;
import com.movieflix.domain.exceptions.UserNotFoundException;
import com.movieflix.domain.user.entity.User;
import com.movieflix.domain.user.repository.UserRepository;
import com.movieflix.security.jwt.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String auth(AuthUserRequest authUserRequest) {

        User user = userRepository.findByEmail(authUserRequest.email())
                .orElseThrow(UserNotFoundException::new);


        boolean passwordMatches = passwordEncoder.matches(authUserRequest.password(), user.getPassword());

        if(!passwordMatches) {
            throw new UserNotFoundException();
        }

        return tokenService.generateToker(user);
    }

}
