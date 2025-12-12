package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.mapper.MovieMapper;
import com.movieflix.domain.movie.response.MovieResponse;
import com.movieflix.domain.movie.service.FindAllMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movies")
public class FindAllMoviesController {

    @Autowired
    private FindAllMoviesService findAllMoviesService;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> handler() {

        List<Movie> movieList = findAllMoviesService.findAll();

        List<MovieResponse> movieResponseList = movieList
                .stream().map(movie -> MovieMapper.toMovieResponse(movie))
                .toList();

        return ResponseEntity.ok(movieResponseList);
    }

}
