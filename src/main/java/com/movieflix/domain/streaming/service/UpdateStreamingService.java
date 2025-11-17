package com.movieflix.domain.streaming.service;


import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import com.movieflix.exceptions.resourceNotFound.ResourceNorFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStreamingService {

    @Autowired
    private StreamingRepository repository;

    @Transactional
    public Streaming execute(Long id, Streaming streaming) {

        var streamingUpdated = repository.findById(id)
                .orElseThrow(() -> new ResourceNorFoundException("This streaming not found"));

         streamingUpdated.update(streaming.getName());

        System.out.println(streamingUpdated);

         return streamingUpdated;

    }

}
