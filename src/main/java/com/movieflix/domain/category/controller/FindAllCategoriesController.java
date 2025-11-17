package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.DTO.CategoryResponse;
import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.mapper.CategoryMapper;
import com.movieflix.domain.category.service.FindAllCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
public class FindAllCategoriesController {

    @Autowired
    private FindAllCategoriesService service;

    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> handler(@PageableDefault(size = 20) Pageable pageable) {

        var pageResponse = service.execute(pageable)
                .map(c -> CategoryMapper.toCategoryResponse(c));

        return ResponseEntity.ok(pageResponse);

    }

}
