package com.movieflix.domain.movie.controller;

import com.movieflix.domain.movie.dto.MovieResponse;
import com.movieflix.domain.movie.mapper.MovieMapper;
import com.movieflix.domain.movie.service.SearchMovieByTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/movieflix/movie")
public class SearchMovieByTitleController {

    @Autowired
    private SearchMovieByTitleService searchMovieByTitleService;

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> handler(@RequestParam String title) {

        var movies = this.searchMovieByTitleService.execute(title);

        var moviesResponse = movies
                .stream()
                .map(movie -> MovieMapper.toMovieResponse(movie)).toList();

        return ResponseEntity.ok(moviesResponse);

    }

}
