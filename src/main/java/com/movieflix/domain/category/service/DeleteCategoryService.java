package com.movieflix.domain.category.service;

import com.movieflix.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryService {

    @Autowired
    private CategoryRepository repository;

    public void execute(Long id) {

        repository.deleteById(id);

    }

}
