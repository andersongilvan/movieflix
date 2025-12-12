package com.movieflix.domain.movie.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.movieflix.domain.category.response.CategoryResponse;
import com.movieflix.domain.streaming.response.StreamingResponse;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record MovieResponse(

        Long id,

        String title,

        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
        LocalDate releaseDate,

        double rating,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
        LocalDateTime createdAt,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
        LocalDateTime updatedAt,

        List<CategoryResponse> categoryResponses,

        List<StreamingResponse> streamingResponses
) {
}
