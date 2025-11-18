package com.movieflix.domain.movie.dto;

import com.movieflix.domain.category.DTO.CategoryResponse;
import com.movieflix.domain.streaming.DTO.StreamingResponse;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        Long id,
        String title,
        String description,
        String imgUrl,
        LocalDate releaseDate,
        LocalDate createdAt,
        LocalDate updatedAt,
        List<CategoryResponse> categoryResponseList,
        List<StreamingResponse> streamingResponseList
) {
}
