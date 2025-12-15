package com.movieflix.security;


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
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        SecurityContextHolder.getContext().setAuthentication(null);

        String header = request.getHeader("Authorization");


        if (header != null && header.startsWith("Bearer ")) {
            var tokenData = tokenService.validateToken(header);

            try {
                request.setAttribute("name", tokenData.name());
                request.setAttribute("UserId", tokenData.id());
                System.out.println(tokenData);

                UsernamePasswordAuthenticationToken auth
                        = new UsernamePasswordAuthenticationToken(tokenData, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception ex) {
                ex.getMessage();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }

        }

        filterChain.doFilter(request, response);

    }
}


