package com.movieflix.domain.streaming.services;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStreamingService {

    @Autowired
    private StreamingRepository streamingRepository;

    public Streaming update(Long id, Streaming streaming) {

        var streamingOptional = streamingRepository.findById(id);

        if (streamingOptional.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var streamingUpdated = streamingOptional.get();

        streamingUpdated.setTitle(streaming.getTitle());

        return streamingRepository.save(streamingUpdated);

    }

}
