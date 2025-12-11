package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.CategoryMapper;
import com.movieflix.domain.category.response.CategoryResponse;
import com.movieflix.domain.category.services.FindCategoryByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/category")
public class FindCategoryByIdController {

    @Autowired
    private FindCategoryByIdService findCategoryByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> handler(@PathVariable Long id) {

        var category = findCategoryByIdService.findCategoryById(id);

        var categoryResponse = CategoryMapper.toCategoryResponse(category);

        return ResponseEntity.ok(categoryResponse);

    }
}
