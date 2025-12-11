package com.movieflix.domain.streaming.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotBlank(message = "O campo titulo é obrigatório") String title) {
}
