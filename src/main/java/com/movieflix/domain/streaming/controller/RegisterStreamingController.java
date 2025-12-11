package com.movieflix.domain.streaming.controller;


import com.movieflix.domain.streaming.mapper.StreamingMapper;
import com.movieflix.domain.streaming.request.StreamingRequest;
import com.movieflix.domain.streaming.response.StreamingResponse;
import com.movieflix.domain.streaming.services.RegisterStreamingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/streaming")
public class RegisterStreamingController {

    @Autowired
    private RegisterStreamingService registerStreamingService;

    @PostMapping
    public ResponseEntity<StreamingResponse> handler(@Valid @RequestBody StreamingRequest streamingRequest) {
        var streaming = StreamingMapper.toStreaming(streamingRequest);

        var streamingSaved = registerStreamingService.register(streaming);

        var streamingResponse = StreamingMapper.toStreamingResponse(streamingSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(streamingResponse);
    }

}
