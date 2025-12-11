package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.CategoryMapper;
import com.movieflix.domain.movie.entity.Category;
import com.movieflix.domain.movie.request.CategoryRequest;
import com.movieflix.domain.movie.response.CategoryResponse;
import com.movieflix.domain.movie.services.RegisterCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/category")
public class RegisterCategoryController {

    @Autowired
    private RegisterCategoryService registerCategoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> handler(@RequestBody @Valid CategoryRequest categoryRequest) {
        var category = CategoryMapper.toCategory(categoryRequest);

        Category categoryCreated = registerCategoryService.registerCategory(category);

        CategoryResponse categoryResponse = CategoryMapper.toCategoryResponse(categoryCreated);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(categoryResponse);

    }

}
