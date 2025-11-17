package com.movieflix.domain.streaming.DTO;


import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}
