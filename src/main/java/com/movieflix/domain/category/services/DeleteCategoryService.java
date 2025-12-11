package com.movieflix.domain.category.services;


import com.movieflix.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
