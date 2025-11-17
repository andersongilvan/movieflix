package com.movieflix.domain.category.mapper;

import com.movieflix.domain.category.DTO.CategoryRequest;
import com.movieflix.domain.category.DTO.CategoryResponse;
import com.movieflix.domain.category.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {

        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();

    }

}
