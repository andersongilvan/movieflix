package com.movieflix.domain.movie.service;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindMovieByCategoryService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findByCategory(Long categoryId) {

        Optional<List<Movie>> optionalMovies = movieRepository.findByCategory(categoryId);

        if (optionalMovies.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return optionalMovies.get();

    }

}
