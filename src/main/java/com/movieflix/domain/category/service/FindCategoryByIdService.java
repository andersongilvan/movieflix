package com.movieflix.domain.category.service;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.repository.CategoryRepository;
import com.movieflix.exceptions.resourceNotFound.ResourceNorFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCategoryByIdService {

    @Autowired
    private CategoryRepository repository;

    public Category execute(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNorFoundException("This category not found"));
    }

}
