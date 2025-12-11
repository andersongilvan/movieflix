package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.services.DeleteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/category")
public class DeleteCategoryController {

    @Autowired
    private DeleteCategoryService deleteCategoryService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> handler(@PathVariable Long id) {
        deleteCategoryService.deleteCategory(id);

        return ResponseEntity.noContent().build();
    }

}
