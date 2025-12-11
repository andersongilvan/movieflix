package com.movieflix.domain.movie;


import com.movieflix.domain.movie.entity.Category;
import com.movieflix.domain.movie.request.CategoryRequest;
import com.movieflix.domain.movie.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .title(categoryRequest.title())
                .build();
    }

    public CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .title(category.getTitle())
                .build();
    }

}
