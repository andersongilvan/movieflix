package com.movieflix.security;


import com.movieflix.domain.exceptions.InvalidTokenException;
import com.movieflix.security.jwt.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;



    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();

        return path.startsWith("/swagger-ui")
                || path.startsWith("/v3/api-docs")
                || path.startsWith("/swagger-resources")
                || path.equals("/movieflix/user")
                || path.equals("/movieflix/user/auth");
    }




    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            System.out.println("Invalid Token");
            return;
        }

        var tokenData = tokenService.validateToken(header);
        System.out.println(tokenData);

        UsernamePasswordAuthenticationToken auth
                = new UsernamePasswordAuthenticationToken(tokenData, null, Collections.emptyList());

        SecurityContextHolder.getContext().setAuthentication(auth);

        System.out.println("auth -> " + auth);

        filterChain.doFilter(request, response);
    }
}


