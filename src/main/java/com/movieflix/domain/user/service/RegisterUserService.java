package com.movieflix.domain.user.service;


import com.movieflix.domain.user.entity.Users;
import com.movieflix.domain.user.repository.UsersRepository;
import com.movieflix.exceptions.resourceAlreadyExists.ResourceAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UsersRepository usersRepository;

    public Users execute(Users user) {

        var userWithEmailDuplicated = this.usersRepository.findByEmail(user.getEmail());

        if (userWithEmailDuplicated.isPresent()) {
            throw new ResourceAlreadyExistException("This email already exists");
        }

        return this.usersRepository.save(user);

    }
}
