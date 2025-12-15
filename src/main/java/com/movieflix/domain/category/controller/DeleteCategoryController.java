package com.movieflix.domain.category.controller;


import com.movieflix.domain.category.services.DeleteCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Tag(
            name = "Delete category",
            description = "Endpoint for delete a category"
    )
    public ResponseEntity<Void> handler(@PathVariable Long id) {
        deleteCategoryService.deleteCategory(id);

        return ResponseEntity.noContent().build();
    }

}
