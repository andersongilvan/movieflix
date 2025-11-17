package com.movieflix.domain.category.controller;

import com.movieflix.domain.category.service.DeleteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/category")

public class DeleteCategoryController {

    @Autowired
    private DeleteCategoryService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> handler(@PathVariable Long id) {

        service.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
