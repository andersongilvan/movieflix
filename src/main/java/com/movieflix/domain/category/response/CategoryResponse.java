package com.movieflix.domain.category.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String title) {
}
