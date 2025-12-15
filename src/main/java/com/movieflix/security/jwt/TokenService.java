package com.movieflix.security.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.movieflix.domain.exceptions.InvalidTokenException;
import com.movieflix.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${spring.jwt.secretKey}")
    private String secretKey;


    public String generateToker(User user) {

        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);

        String token = JWT.create()
                .withIssuer("movieflix")
                .withSubject(user.getId().toString())
                .withClaim("name", user.getName())
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .sign(algorithm);

        return token;
    }

    public TokenData validateToken(String token) {

        token = token.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);

        try {
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            var sub = jwt.getSubject();

            var name = jwt.getClaim("name").asString();

            return new TokenData(sub, name);

        } catch (JWTVerificationException ex) {
            throw new InvalidTokenException();
        }
    }
}


