package com.movieflix.domain.category.DTO;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "Required field") String name) {
}
