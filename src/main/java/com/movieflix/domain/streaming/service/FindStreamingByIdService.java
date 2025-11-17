package com.movieflix.domain.streaming.service;


import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import com.movieflix.exceptions.ResourceNorFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindStreamingByIdService {

    @Autowired
    private StreamingRepository repository;

    public Streaming execute(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNorFoundException("This streaming not found"));
    }

}
