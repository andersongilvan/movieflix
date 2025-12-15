package com.movieflix.domain.movie.controller;


import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.mapper.MovieMapper;
import com.movieflix.domain.movie.response.MovieResponse;
import com.movieflix.domain.movie.service.FindMovieByCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie-category")
public class FindMoviesByCategoryController {

    @Autowired
    private FindMovieByCategoryService findMovieByCategoryService;

    @GetMapping("/{idCategory}")
    @Tag(
            name = "find movies by category",
            description = "Endpoint for list movies by categories"
    )
    public ResponseEntity<List<MovieResponse>> handler(@PathVariable Long idCategory) {

        List<Movie> movieList = findMovieByCategoryService.findByCategory(idCategory);

        List<MovieResponse> movieResponseList = movieList.stream()
                .map(movie -> MovieMapper.toMovieResponse(movie)).toList();

        return ResponseEntity.ok(movieResponseList);

    }

}
