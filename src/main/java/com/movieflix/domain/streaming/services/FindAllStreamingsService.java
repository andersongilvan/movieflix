package com.movieflix.domain.streaming.services;


import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllStreamingsService {

    @Autowired
    private StreamingRepository streamingRepository;

    public List<Streaming> findAll() {

        return streamingRepository.findAllByOrderByTitleAsc();
    }

}
