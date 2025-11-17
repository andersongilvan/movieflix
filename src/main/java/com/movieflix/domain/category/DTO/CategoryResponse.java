package com.movieflix.domain.category.DTO;


import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
