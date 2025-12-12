package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.mapper.MovieMapper;
import com.movieflix.domain.movie.request.MovieRequest;
import com.movieflix.domain.movie.response.MovieResponse;
import com.movieflix.domain.movie.service.RegisterMovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/movie")
public class RegisterMovieController {

    @Autowired
    private RegisterMovieService registerMovieService;

    @PostMapping
    public ResponseEntity<MovieResponse> handler(@Valid @RequestBody MovieRequest movieRequest) {

        System.out.println(movieRequest);

        Movie movieRegistered = registerMovieService.register(MovieMapper.toMovie(movieRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(movieRegistered));

    }
}
