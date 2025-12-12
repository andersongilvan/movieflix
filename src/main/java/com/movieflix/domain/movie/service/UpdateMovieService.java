package com.movieflix.domain.movie.service;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.services.FindCategoriesService;
import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.services.FindStreamingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private FindCategoriesService findCategoriesService;

    @Autowired
    private FindStreamingsService findStreamingsService;


    public Movie update(Long movieId, Movie movieUpdated) {

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(ResourceNotFoundException::new);

        List<Category> categoryListUpdated = findCategoriesService.findCategories(movieUpdated.getCategories());

        List<Streaming> streamingListUpdated = findStreamingsService.findStreamings(movieUpdated.getStreamings());


        movie.setTitle(movieUpdated.getTitle());
        movie.setDescription(movieUpdated.getDescription());
        movie.setRating(movieUpdated.getRating());

        movie.getCategories().clear();
        movie.setCategories(categoryListUpdated);

        movie.getStreamings().clear();
        movie.setStreamings(streamingListUpdated);


        return movieRepository.save(movie);

    }

}
