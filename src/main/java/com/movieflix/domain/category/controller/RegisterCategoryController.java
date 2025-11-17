package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.DTO.CategoryRequest;
import com.movieflix.domain.category.DTO.CategoryResponse;
import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.mapper.CategoryMapper;
import com.movieflix.domain.category.service.RegisterCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/category")
public class RegisterCategoryController {

    @Autowired
    private RegisterCategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponse>  handler(@Valid @RequestBody CategoryRequest data) {

        var category = CategoryMapper.toCategory(data);

        var result = service.execute(category);

        return ResponseEntity.status(201).body(CategoryMapper.toCategoryResponse(result));

    }

}
