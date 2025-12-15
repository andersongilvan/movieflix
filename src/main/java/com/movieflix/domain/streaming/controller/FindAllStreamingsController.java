package com.movieflix.domain.streaming.controller;


import com.movieflix.domain.streaming.mapper.StreamingMapper;
import com.movieflix.domain.streaming.response.StreamingResponse;
import com.movieflix.domain.streaming.services.FindAllStreamingsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streamins")
public class FindAllStreamingsController {

    @Autowired
    private FindAllStreamingsService findAllStreamingsService;

    @GetMapping
    @Tag(
            name = "Find all streamings",
            description = "Endpoint for list all streamings"
    )
    public ResponseEntity<List<StreamingResponse>> handler() {

        var streamings = findAllStreamingsService.findAll();

        var streamingsResponse = streamings
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();

        return ResponseEntity.ok(streamingsResponse);

    }

}
