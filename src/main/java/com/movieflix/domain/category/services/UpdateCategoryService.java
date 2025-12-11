package com.movieflix.domain.category.services;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category updateCategory(Long id, Category categoryUpdated) {

        var categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var category = categoryOptional.get();
        category.setTitle(categoryUpdated.getTitle());

        return categoryRepository.save(category);

    }

}
