package com.movieflix.domain.streaming.services;


import com.movieflix.domain.exceptions.ResourceAlreadyExistsException;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterStreamingService {

    @Autowired
    private StreamingRepository streamingRepository;

    public Streaming register(Streaming streaming) {

        var streamingWithSameName = streamingRepository.findStreamingByTitle(streaming.getTitle());

        if (streamingWithSameName.isPresent()) {
            throw new ResourceAlreadyExistsException();
        }

        return streamingRepository.save(streaming);
    }

}
