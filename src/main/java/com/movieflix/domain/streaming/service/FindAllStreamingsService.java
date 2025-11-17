package com.movieflix.domain.streaming.service;

import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllStreamingsService {

    @Autowired
    private StreamingRepository repository;

    public Page<Streaming> execute(Pageable pageable) {

        return repository.findAll(pageable);

    }

}
