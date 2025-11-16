package com.movieflix.domain.category.service;

import com.movieflix.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCategoryService {

    @Autowired
    private CategoryRepository repository;

}
