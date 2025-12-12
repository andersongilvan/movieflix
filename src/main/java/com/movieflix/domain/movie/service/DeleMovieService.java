package com.movieflix.domain.movie.service;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleMovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void delete(Long idMovie) {

        Movie movieExists = movieRepository.findById(idMovie)
                .orElseThrow(ResourceNotFoundException::new);

        movieRepository.deleteById(movieExists.getId());

    }

}
