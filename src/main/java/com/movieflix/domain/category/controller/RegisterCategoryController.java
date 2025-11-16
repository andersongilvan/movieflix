package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.service.RegisterCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/category")
public class RegisterCategoryController {

    @Autowired
    private RegisterCategoryService service;
}
