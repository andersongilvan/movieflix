package com.movieflix.domain.streaming.services;


import com.movieflix.domain.exceptions.ResourceNotFoundException;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FindStreamingsService {

    @Autowired
    private StreamingRepository streamingRepository;

    public List<Streaming> findStreamings(List<Streaming> streamings) {

        List<Streaming> streamingList = new ArrayList<>();

        streamings.forEach(streaming -> {
            Optional<Streaming> optionalStreaming = streamingRepository.findById(streaming.getId());

            if (optionalStreaming.isEmpty()) {
                throw new ResourceNotFoundException();
            }

            streamingList.add(optionalStreaming.get());

        });

        return streamingList;

    }
}
