package com.movieflix.domain.movie.service;


import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllMoviesService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie>findAll() {

        return movieRepository.findAll();
    }

}
