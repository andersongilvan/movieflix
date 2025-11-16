package com.movieflix.domain.category.service;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCategoriesService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> execute() {
        return  repository.findAll();
    }

}
