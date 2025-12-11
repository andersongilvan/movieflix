package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.CategoryMapper;
import com.movieflix.domain.movie.response.CategoryResponse;
import com.movieflix.domain.movie.services.FindCategoryByIdService;
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
