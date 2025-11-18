package com.movieflix.domain.movie.service;


import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import com.movieflix.exceptions.resourceNotFound.ResourceNorFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindMovieByIdService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie execute(Long id) {

        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNorFoundException("This movie not found"));

    }

}
