package com.movieflix.domain.user.service;


import com.movieflix.domain.user.entity.Users;
import com.movieflix.domain.user.repository.UsersRepository;
import com.movieflix.exceptions.resourceAlreadyExists.ResourceAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users execute(Users user) {

        var userWithEmailDuplicated = this.usersRepository.findByEmail(user.getEmail());

        if (userWithEmailDuplicated.isPresent()) {
            throw new ResourceAlreadyExistException("This email already exists");
        }

        var password = user.getHashPassword();

        user.setHashPassword(this.passwordEncoder.encode(password));

        return this.usersRepository.save(user);

    }
}
