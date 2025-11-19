package com.movieflix.domain.auth.DTO;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Required field")
        String email,

        @NotBlank(message = "Required field")
        String password) {
}
