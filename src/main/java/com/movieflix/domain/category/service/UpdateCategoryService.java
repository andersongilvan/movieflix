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
    private CategoryRepository categoryRepository;

    @Transactional
    public Category execute(Long idCategory, Category category) {

        var categoryOptional = categoryRepository.findById(idCategory);
        if (categoryOptional.isEmpty()) {
            throw new ResourceNorFoundException("This category not found");
        }

        var categorySaved = categoryOptional.get();

        categorySaved.setName(category.getName());

        return categorySaved;

    }

}
