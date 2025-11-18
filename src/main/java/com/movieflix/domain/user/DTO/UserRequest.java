package com.movieflix.domain.user.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "Required field")
        @Min(value = 6, message = "The name field must contain at least 6 characters.")
        String name,

        @Email(message = "The email field must contain a valid email address.")
        String email,

        @NotBlank(message = "Required field")
        String password
) {
}
