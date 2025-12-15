package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.CategoryMapper;
import com.movieflix.domain.category.request.CategoryRequest;
import com.movieflix.domain.category.response.CategoryResponse;
import com.movieflix.domain.category.services.UpdateCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Tag(
            name = "Update category",
            description = "Endpoint for update a category"
    )
    public ResponseEntity<CategoryResponse> handler(@PathVariable Long id, @RequestBody @Valid CategoryRequest categoryRequest) {

        System.out.println("Request -> " + categoryRequest);

        var category = CategoryMapper.toCategory(categoryRequest);

        var categoryUpdated = updateCategoryService.updateCategory(id, category);

        var categoryResponse = CategoryMapper.toCategoryResponse(categoryUpdated);

        return ResponseEntity.ok(categoryResponse);

    }

}
