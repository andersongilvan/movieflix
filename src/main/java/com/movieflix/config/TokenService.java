package com.movieflix.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.movieflix.domain.user.entity.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService {

    @Value("${movieflix.secret.key}")
    private String secret;

    public String generateToken(Users user) {

        var algorithm = Algorithm.HMAC256(this.secret);

        return JWT.create()
                .withClaim("userId", user.getId())
                .withClaim("name", user.getName())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API Movieflix")
                .sign(algorithm);
    }
}
