package com.movieflix.domain.streaming.service;


import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import com.movieflix.exceptions.resourceAlreadyExists.ResourceAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterStreamingService {

    @Autowired
    private StreamingRepository repository;

    public Streaming execute(Streaming streaming) {

        var streamingWithSameName = repository.findByName(streaming.getName());

        if(streamingWithSameName != null) {
            throw new ResourceAlreadyExistException("This streaming already exists");
        }

        return repository.save(streaming);

    }

}
