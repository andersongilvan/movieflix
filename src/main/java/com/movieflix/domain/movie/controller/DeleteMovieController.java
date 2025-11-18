package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.service.DeleteMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/movie")
public class DeleteMovieController {

    @Autowired
    private DeleteMovieService deleteMovieService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> handler(@PathVariable Long id) {

        deleteMovieService.execute(id);

        return ResponseEntity.noContent().build();

    }

}
