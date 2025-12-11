package com.movieflix.domain.streaming.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String title) {
}
