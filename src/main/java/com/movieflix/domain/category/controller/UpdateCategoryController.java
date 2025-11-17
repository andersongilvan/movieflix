package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.DTO.CategoryRequest;
import com.movieflix.domain.category.DTO.CategoryResponse;
import com.movieflix.domain.category.mapper.CategoryMapper;
import com.movieflix.domain.category.service.UpdateCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieflix/category")
public class UpdateCategoryController {

    @Autowired
    private UpdateCategoryService service;

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> handler(@PathVariable Long id,
                                                    @RequestBody CategoryRequest request) {

        var categoryRequest = CategoryMapper.toCategory(request);

        var category = service.execute(id, categoryRequest);

        return ResponseEntity.ok(CategoryMapper.toCategoryResponse(category));
    }

}
