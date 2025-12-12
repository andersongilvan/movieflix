package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.service.DeleMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movieflix/movie")
public class DeleteMovieController {

    @Autowired
    private DeleMovieService deleMovieService;

    @DeleteMapping("/{idMovie}")
    public ResponseEntity<Void>handler(@PathVariable Long idMovie) {
        deleMovieService.delete(idMovie);

        return ResponseEntity.noContent().build();
    }

}
