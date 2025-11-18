package com.movieflix.domain.movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        @NotBlank(message = "Required filed")
        String title,

        @NotBlank(message = "Required filed")
        String description,

        @NotBlank(message = "Required filed")
        String imgUrl,

        @NotNull(message = "Required filed")
        LocalDate releaseDate,

        @NotNull(message = "Required filed")
        double rating,

        @NotNull(message = "Required filed")
        List<Long> categories,

        @NotNull(message = "Required filed")
        List<Long> streaming

) {
}


