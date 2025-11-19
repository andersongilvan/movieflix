package com.movieflix.domain.auth.service;

import com.movieflix.domain.user.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var userOptional = this.usersRepository.findUsersByEmail(email);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User or password invalid");
        }

        return userOptional.get();
    }
}
