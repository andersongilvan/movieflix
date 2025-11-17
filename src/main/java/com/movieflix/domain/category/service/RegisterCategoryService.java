package com.movieflix.domain.category.service;

import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.repository.CategoryRepository;
import com.movieflix.exceptions.resourceAlreadyExists.ResourceAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category execute(Category category) {

        var categoryWithNameDuplicated = repository.findByName(category.getName());

        if (categoryWithNameDuplicated != null) {
            throw new ResourceAlreadyExistException("This category already exist");
        }

        return repository.save(category);

    }

}
