package com.movieflix.domain.category.services;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCategoryByIdService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findCategoryById(Long id) {

        var category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return category.get();
    }

}
