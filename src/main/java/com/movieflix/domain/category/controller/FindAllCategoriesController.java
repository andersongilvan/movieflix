package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.CategoryMapper;
import com.movieflix.domain.movie.response.CategoryResponse;
import com.movieflix.domain.movie.services.FindAllCategoriesService;
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
    public ResponseEntity<Page<CategoryResponse>> handler(@PageableDefault(size = 20) Pageable pageable) {
        var categoriesPage = findAllCategoriesService.findAllCategories(pageable);

        var pageCategoriesResponse = categoriesPage
                .map(category -> CategoryMapper.toCategoryResponse(category));


        return ResponseEntity.ok(pageCategoriesResponse);
    }

}
