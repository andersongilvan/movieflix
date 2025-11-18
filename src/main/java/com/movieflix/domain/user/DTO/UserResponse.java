package com.movieflix.domain.user.DTO;

import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String name,
        String email
) {
}
