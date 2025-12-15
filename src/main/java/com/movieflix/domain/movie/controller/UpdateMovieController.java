package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.mapper.MovieMapper;
import com.movieflix.domain.movie.request.MovieRequest;
import com.movieflix.domain.movie.response.MovieResponse;
import com.movieflix.domain.movie.service.UpdateMovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieflix/movie")
public class UpdateMovieController {

    @Autowired
    private UpdateMovieService updateMovieService;

    @PutMapping("/{idMovie}")
    @Tag(
            name = "Update a movie",
            description = "Endpoint for update a movie"
    )
    public ResponseEntity<MovieResponse> handler(@PathVariable Long idMovie, @Valid @RequestBody MovieRequest movieRequest) {

        Movie movie = MovieMapper.toMovie(movieRequest);

        Movie movieUpdated = updateMovieService.update(idMovie, movie);

        return ResponseEntity.ok(MovieMapper.toMovieResponse(movieUpdated));

    }

}
