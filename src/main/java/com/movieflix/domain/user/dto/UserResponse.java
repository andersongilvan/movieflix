package com.movieflix.domain.user.dto;


import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String name,
        String email

) {
}
