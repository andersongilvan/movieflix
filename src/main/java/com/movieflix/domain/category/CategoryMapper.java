package com.movieflix.domain.category;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.request.CategoryRequest;
import com.movieflix.domain.category.response.CategoryResponse;
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
