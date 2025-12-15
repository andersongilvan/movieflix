package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.CategoryMapper;
import com.movieflix.domain.category.response.CategoryResponse;
import com.movieflix.domain.category.services.FindAllCategoriesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/categories")
public class FindAllCategoriesController {

    @Autowired
    private FindAllCategoriesService findAllCategoriesService;

    @GetMapping
    @Tag(
            name = "Find all categories",
            description = "Endpoint for listing and managing categories"
    )
    public ResponseEntity<Page<CategoryResponse>> handler(@PageableDefault(size = 20) Pageable pageable) {
        var categoriesPage = findAllCategoriesService.findAllCategories(pageable);

        var pageCategoriesResponse = categoriesPage
                .map(category -> CategoryMapper.toCategoryResponse(category));


        return ResponseEntity.ok(pageCategoriesResponse);
    }

}
