package com.movieflix.domain.streaming.services;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStreamingService {

    @Autowired
    private StreamingRepository streamingRepository;

    public void delete(Long id) {
        var streamingOptional = streamingRepository.findById(id);

        if (streamingOptional.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        streamingRepository.deleteById(id);
    }

}
