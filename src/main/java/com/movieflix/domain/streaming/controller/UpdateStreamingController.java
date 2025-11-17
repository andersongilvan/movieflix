package com.movieflix.domain.streaming.controller;


import com.movieflix.domain.streaming.DTO.StreamingRequest;
import com.movieflix.domain.streaming.DTO.StreamingResponse;
import com.movieflix.domain.streaming.mapper.StreamingMapper;
import com.movieflix.domain.streaming.service.UpdateStreamingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieflix/streaming")
public class UpdateStreamingController {

    @Autowired
    private UpdateStreamingService service;

    @PutMapping("/{id}")
    public ResponseEntity<StreamingResponse> handler(@PathVariable Long id,
                                                    @Valid @RequestBody StreamingRequest request) {

        var streaming = StreamingMapper.toStreaming(request);

        var result = service.execute(id, streaming);

        var response = StreamingMapper.toStreamingResponse(result);

        return ResponseEntity.ok(response);

    }

}
