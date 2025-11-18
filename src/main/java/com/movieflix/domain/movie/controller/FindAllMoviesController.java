package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.dto.MovieResponse;
import com.movieflix.domain.movie.mapper.MovieMapper;
import com.movieflix.domain.movie.service.FindAllMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/movie")
public class FindAllMoviesController {

    @Autowired
    private FindAllMoviesService service;

    @GetMapping
    public ResponseEntity<Page<MovieResponse>> handler(@PageableDefault(size = 20) Pageable pageable) {

        var moviePage = service.execute(pageable)
                .map(movie -> MovieMapper.toMovieResponse(movie));

        return ResponseEntity.ok(moviePage);

    }

}
