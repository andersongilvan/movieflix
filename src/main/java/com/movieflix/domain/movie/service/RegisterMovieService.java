package com.movieflix.domain.movie.service;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.services.FindCategoriesService;
import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.services.FindStreamingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private FindCategoriesService findCategoriesService;

    @Autowired
    FindStreamingsService findStreamingsService;

    public Movie register(Movie movie) {

        List<Category> categoryList = findCategoriesService.findCategories(movie.getCategories());

        List<Streaming> streamingList = findStreamingsService.findStreamings(movie.getStreamings());

        movie.setCategories(categoryList);
        movie.setStreamings(streamingList);

        return movieRepository.save(movie);
    }

}
