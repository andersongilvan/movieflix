package com.movieflix.domain.streaming.service;


import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import com.movieflix.exceptions.resourceNotFound.ResourceNorFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindStreamingByIdService {

    @Autowired
    private StreamingRepository streamingRepository;

    public Streaming execute(Long idStreaming) {

        var streamingOptional = this.streamingRepository.findById(idStreaming);

        if (streamingOptional.isEmpty()) {
            throw new ResourceNorFoundException("This streaming not found");
        }

        return streamingOptional.get();
    }

}
