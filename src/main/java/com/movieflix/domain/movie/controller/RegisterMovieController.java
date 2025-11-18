package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.dto.MovieRequest;
import com.movieflix.domain.movie.dto.MovieResponse;
import com.movieflix.domain.movie.mapper.MovieMapper;
import com.movieflix.domain.movie.service.RegisterMovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/movie")
public class RegisterMovieController {

    @Autowired
    private RegisterMovieService service;

    @PostMapping
    public ResponseEntity<MovieResponse> handler(@Valid @RequestBody MovieRequest request) {

        var movie = MovieMapper.toMovie(request);

        var result = service.execute(movie);

        var movieResponse = MovieMapper.toMovieResponse(result);

        return ResponseEntity.status(201).body(movieResponse);

    }

}
