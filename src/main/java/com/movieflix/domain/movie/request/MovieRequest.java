package com.movieflix.domain.movie.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;


@Builder
public record MovieRequest(
        @NotBlank(message = "The 'title' field is required")
        String title,
        @NotBlank(message = "The 'description' field is required")
        String description,
        @NotNull(message = "The 'release-date' field is required")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
        LocalDate releaseDate,
        @NotNull(message = "The 'rating' field is required")
        double rating,
        @NotNull(message = "The 'categories' field is required")
        List<Long> categories,
        @NotNull(message = "The 'streamings' field is required")
        List<Long> streamings
) {
}
