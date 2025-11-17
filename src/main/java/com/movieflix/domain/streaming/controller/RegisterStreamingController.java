package com.movieflix.domain.streaming.controller;


import com.movieflix.domain.streaming.DTO.StreamingRequest;
import com.movieflix.domain.streaming.DTO.StreamingResponse;
import com.movieflix.domain.streaming.mapper.StreamingMapper;
import com.movieflix.domain.streaming.service.RegisterStreamingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/streaming")
public class RegisterStreamingController {

    @Autowired
    private RegisterStreamingService service;

    @PostMapping
    public ResponseEntity<StreamingResponse> handler(@Valid @RequestBody StreamingRequest request) {

        var streaming = StreamingMapper.toStreaming(request);

        var result = service.execute(streaming);

        var response = StreamingMapper.toStreamingResponse(result);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(response);

    }

}
