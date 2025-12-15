package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.service.DeleMovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Tag(
            name = "Delete movie",
            description = "Endpoint for delete a movie"
    )
    public ResponseEntity<Void>handler(@PathVariable Long idMovie) {
        deleMovieService.delete(idMovie);

        return ResponseEntity.noContent().build();
    }

}
