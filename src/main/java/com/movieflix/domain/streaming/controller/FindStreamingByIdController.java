package com.movieflix.domain.streaming.controller;


import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.mapper.StreamingMapper;
import com.movieflix.domain.streaming.response.StreamingResponse;
import com.movieflix.domain.streaming.services.FindStreamingByIdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/streaming")
public class FindStreamingByIdController {

    @Autowired
    private FindStreamingByIdService findStreamingByIdService;

    @GetMapping("/{id}")
    @Tag(
            name = "Find streaming by id",
            description = "Endpoint for find streaming by id"
    )
    public ResponseEntity<StreamingResponse> handler(@PathVariable Long id) {
        var streaming = findStreamingByIdService.findById(id);

        var streamingResponse = StreamingMapper.toStreamingResponse(streaming);

        return ResponseEntity.ok(streamingResponse);
    }
}
