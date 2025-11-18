package com.movieflix.domain.movie.service;


import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.service.FindCategoryByIdService;
import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.service.FindStreamingByIdService;
import com.movieflix.exceptions.resourceAlreadyExists.ResourceAlreadyExistException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private FindCategoryByIdService findCategoryByIdService;

    @Autowired
    private FindStreamingByIdService findStreamingByIdService;

    @Transactional
    public Movie execute(Movie movie) {

        var movieWithTitleDuplicated = movieRepository.findByTitle(movie.getTitle());

        if (movieWithTitleDuplicated.isPresent()) {
            throw new ResourceAlreadyExistException("This movie already exists");
        }


        var categoryList = this.findCategories(movie.getCategories());
        var streamingList = this.findStreamings(movie.getStreamings());

        movie.setCategories(categoryList);
        movie.setStreamings(streamingList);

        return this.movieRepository.save(movie);
    }

    private List<Category> findCategories(List<Category> categories) {
        return categories
                .stream()
                .map(category -> this.findCategoryByIdService.execute(category.getId()))
                .toList();
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        return streamings
                .stream()
                .map(streaming -> this.findStreamingByIdService.execute(streaming.getId()))
                .toList();
    }

}
