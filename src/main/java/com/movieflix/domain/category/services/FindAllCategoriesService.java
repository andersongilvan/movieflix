package com.movieflix.domain.movie.services;


import com.movieflix.domain.movie.entity.Category;
import com.movieflix.domain.movie.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindAllCategoriesService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> findAllCategories(Pageable pageable) {

        return categoryRepository.findAll(pageable);

    }

}
