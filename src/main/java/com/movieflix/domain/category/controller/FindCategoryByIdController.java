package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.DTO.CategoryResponse;
import com.movieflix.domain.category.mapper.CategoryMapper;
import com.movieflix.domain.category.service.FindCategoryByIdService;
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
    private FindCategoryByIdService service;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> handler(@PathVariable Long id) {

        var category = service.execute(id);

       return ResponseEntity.ok(CategoryMapper.toCategoryResponse(category));

    }

}
