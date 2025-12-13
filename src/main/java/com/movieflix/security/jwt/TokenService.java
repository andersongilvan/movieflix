package com.movieflix.security.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.movieflix.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${spring.jwt.secretKey}")
    private String secretKey;


    public String generateToker(User user) {

        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);

        return JWT.create()
                .withIssuer("movieflix")
                .withSubject(user.getId().toString())
                .sign(algorithm);

    }

}
