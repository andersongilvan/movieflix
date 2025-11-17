package com.movieflix.domain.streaming.service;


import com.movieflix.domain.streaming.repository.StreamingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStreamingService {

    @Autowired
    private StreamingRepository repository;

    @Transactional
    public void execute(Long id) {

        repository.deleteById(id);

    }

}
