package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.mapper.MovieMapper;
import com.movieflix.domain.movie.response.MovieResponse;
import com.movieflix.domain.movie.service.FindMovieByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/movie")
public class FindMovieByIdController {

    @Autowired
    private FindMovieByIdService findMovieByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> handler(@PathVariable Long id) {

        Movie movie = findMovieByIdService.findById(id);

        return ResponseEntity.ok(MovieMapper.toMovieResponse(movie));

    }

}
