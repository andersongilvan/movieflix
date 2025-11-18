package com.movieflix.domain.movie.service;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.service.FindCategoryByIdService;
import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.service.FindStreamingByIdService;
import com.movieflix.exceptions.resourceNotFound.ResourceNorFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private FindCategoryByIdService findCategoryByIdService;

    @Autowired
    private FindStreamingByIdService findStreamingByIdService;


    @Transactional
    public Movie execute(Long idMovie, Movie updateMovie) {

        var optionalMovie = movieRepository.findById(idMovie);

        if (optionalMovie.isEmpty()) {
            throw new ResourceNorFoundException("This movie not found");
        }

        var movie = optionalMovie.get();

        var categories = this.findCategories(updateMovie.getCategories());
        var streamings = this.findStreamings(updateMovie.getStreamings());

        movie.setTitle(updateMovie.getTitle());
        movie.setDescription(updateMovie.getDescription());
        movie.setReleaseDate(updateMovie.getReleaseDate());
        movie.setRating(updateMovie.getRating());

        movie.getCategories().clear();
        movie.setCategories(categories);

        movie.getStreamings().clear();
        movie.setStreamings(streamings);

        return movie;
    }

    private List<Category> findCategories(List<Category> categories) {
        return categories
                .stream()
                .map(category -> this.findCategoryByIdService.execute(category.getId()))
                .toList();
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        return streamings.stream()
                .map(streaming -> this.findStreamingByIdService.execute(streaming.getId()))
                .toList();
    }
}
