package com.movieflix.domain.streaming.DTO;

import jakarta.validation.constraints.NotBlank;

public record StreamingRequest(@NotBlank(message = "Required field") String name) {
}
