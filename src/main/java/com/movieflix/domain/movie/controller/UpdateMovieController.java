package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.dto.MovieRequest;
import com.movieflix.domain.movie.dto.MovieResponse;
import com.movieflix.domain.movie.mapper.MovieMapper;
import com.movieflix.domain.movie.service.UpdateMovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieflix/movie")
public class UpdateMovieController {

    @Autowired
    private UpdateMovieService updateMovieService;

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> handler(@PathVariable Long id,
                                                 @Valid @RequestBody MovieRequest request) {

        var movie = MovieMapper.toMovie(request);

        var movieUpdated = updateMovieService.execute(id, movie);

        var movieResponse = MovieMapper.toMovieResponse(movieUpdated);

        return ResponseEntity.ok(movieResponse);

    }

}
