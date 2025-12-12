package com.movieflix.domain.movie.service;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindMovieByIdService {

    @Autowired
    MovieRepository movieRepository;

    public Movie findById(Long id) {

        Optional<Movie> movieOptional = movieRepository.findById(id);

        if (movieOptional.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return movieOptional.get();

    }

}
