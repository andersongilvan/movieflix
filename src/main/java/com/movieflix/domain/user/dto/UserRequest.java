package com.movieflix.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "The field 'name' is required")
        String name,

        @NotBlank(message = "The field 'e-mail' is required")
        @Email(message = "The email field must contain a valid email")
        String email,

        @NotBlank(message = "The field 'password' is required")
        String password
) {
}
