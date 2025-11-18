package com.movieflix.domain.movie.service;


import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindAllMoviesService {

    @Autowired
    private MovieRepository repository;

    public Page<Movie> execute(Pageable pageable) {

        return repository.findAll(pageable);

    }

}
