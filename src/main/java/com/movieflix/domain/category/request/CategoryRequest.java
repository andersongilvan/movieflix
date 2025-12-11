package com.movieflix.domain.category.request;

import org.hibernate.validator.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "Title is required") String title) {
}
