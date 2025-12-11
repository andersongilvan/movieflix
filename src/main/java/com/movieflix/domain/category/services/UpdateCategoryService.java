package com.movieflix.domain.movie.services;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.movie.entity.Category;
import com.movieflix.domain.movie.repository.CategoryRepository;
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
