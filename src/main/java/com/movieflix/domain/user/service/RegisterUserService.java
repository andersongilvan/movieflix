package com.movieflix.domain.user.service;


import com.movieflix.domain.exceptions.EmailAlreadyExistsException;
import com.movieflix.domain.exceptions.UserNotFoundException;
import com.movieflix.domain.user.entity.User;
import com.movieflix.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user) {

        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new EmailAlreadyExistsException();
                });

        String passwordRash = passwordEncoder.encode(user.getPassword());

        user.setPassword(passwordRash);

        return userRepository.save(user);

    }

}
