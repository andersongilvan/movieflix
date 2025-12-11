package com.movieflix.domain.movie.services;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.movie.entity.Category;
import com.movieflix.domain.movie.repository.CategoryRepository;
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
