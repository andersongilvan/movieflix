package com.movieflix.domain.streaming.controller;


import com.movieflix.domain.streaming.mapper.StreamingMapper;
import com.movieflix.domain.streaming.request.StreamingRequest;
import com.movieflix.domain.streaming.response.StreamingResponse;
import com.movieflix.domain.streaming.services.UpdateStreamingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieflix/streaming")
public class UpdateStreamingController {

    @Autowired
    private UpdateStreamingService updateStreamingService;

    @PutMapping("/{id}")
    public ResponseEntity<StreamingResponse> handler(@PathVariable Long id, @Valid @RequestBody StreamingRequest streamingRequest) {
        var streaming = StreamingMapper.toStreaming(streamingRequest);

        var streamingUpdated = updateStreamingService.update(id, streaming);

        var streamingResponse = StreamingMapper.toStreamingResponse(streamingUpdated);

        return ResponseEntity.ok(streamingResponse);
    }

}
