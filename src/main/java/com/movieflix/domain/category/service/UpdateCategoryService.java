package com.movieflix.domain.category.service;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.repository.CategoryRepository;
import com.movieflix.exceptions.resourceNotFound.ResourceNorFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public Category execute(Long id, Category data) {

       var category = repository.findById(id)
               .orElseThrow(() -> new ResourceNorFoundException("This category not found"));

       category.update(data.getName());

       return category;
    }

}
