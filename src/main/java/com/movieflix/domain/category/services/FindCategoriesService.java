package com.movieflix.domain.category.services;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.repository.CategoryRepository;
import com.movieflix.domain.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FindCategoriesService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> findCategories(List<Category> categories) {
        List<Category> categoryList = new ArrayList<>();

        categories.forEach(category -> {
            Optional<Category> categoryOptional = categoryRepository.findById(category.getId());

            if (categoryOptional.isEmpty()) {
                throw new ResourceNotFoundException();
            }

            categoryList.add(categoryOptional.get());

        });

        return categoryList;
    }

}
