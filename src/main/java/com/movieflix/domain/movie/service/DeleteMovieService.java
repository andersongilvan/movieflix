package com.movieflix.domain.movie.service;


import com.movieflix.domain.movie.repository.MovieRepository;
import com.movieflix.exceptions.resourceNotFound.ResourceNorFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public void execute(Long id) {

        movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNorFoundException("This movie not found"));

        movieRepository.deleteById(id);

    }

}
