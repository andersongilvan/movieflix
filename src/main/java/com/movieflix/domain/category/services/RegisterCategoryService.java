package com.movieflix.domain.category.services;


import com.movieflix.domain.exceptions.ResourceAlreadyExistsException;
import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category registerCategory(Category category) {

        var categoryWthSameTitle = categoryRepository.findCategoryByTitle(category.getTitle());

        if (categoryWthSameTitle.isPresent()) {
            throw new ResourceAlreadyExistsException();
        }

        return categoryRepository.save(category);
    }


}
