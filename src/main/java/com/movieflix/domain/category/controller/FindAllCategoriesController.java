package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.service.FindAllCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Category> handler() {

        return service.execute();

    }

}
