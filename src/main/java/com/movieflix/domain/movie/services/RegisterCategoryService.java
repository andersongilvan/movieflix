package com.movieflix.domain.movie.services;


import com.movieflix.domain.exceptions.ResourceAlreadyExistsException;
import com.movieflix.domain.movie.entity.Category;
import com.movieflix.domain.movie.repository.CategoryRepository;
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
