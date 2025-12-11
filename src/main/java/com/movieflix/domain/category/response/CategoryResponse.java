package com.movieflix.domain.movie.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CategoryResponse(Long id, String title) {
}
