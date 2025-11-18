package com.movieflix.domain.movie.service;

import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import com.movieflix.exceptions.resourceNotFound.ResourceNorFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchMovieByTitleService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> execute(String title) {

        var movies = this.movieRepository.findByTitleContainingIgnoreCase(title);

        if (movies.isEmpty()) {
            throw new ResourceNorFoundException("Movie not found");
        }

        return movies;

    }

}
