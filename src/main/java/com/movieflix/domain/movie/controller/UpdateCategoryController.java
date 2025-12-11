package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.CategoryMapper;
import com.movieflix.domain.movie.request.CategoryRequest;
import com.movieflix.domain.movie.response.CategoryResponse;
import com.movieflix.domain.movie.services.UpdateCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieflix/category")
public class UpdateCategoryController {

    @Autowired
    private UpdateCategoryService updateCategoryService;

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> handler(@PathVariable Long id, @RequestBody @Valid CategoryRequest categoryRequest) {

        System.out.println("Request -> " + categoryRequest);

        var category = CategoryMapper.toCategory(categoryRequest);

        var categoryUpdated = updateCategoryService.updateCategory(id, category);

        var categoryResponse = CategoryMapper.toCategoryResponse(categoryUpdated);

        return ResponseEntity.ok(categoryResponse);

    }

}
