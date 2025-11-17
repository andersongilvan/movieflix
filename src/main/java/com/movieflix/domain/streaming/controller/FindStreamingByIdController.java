package com.movieflix.domain.streaming.controller;


import com.movieflix.domain.streaming.DTO.StreamingResponse;
import com.movieflix.domain.streaming.mapper.StreamingMapper;
import com.movieflix.domain.streaming.service.FindStreamingByIdService;
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
    private FindStreamingByIdService service;

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> handler(@PathVariable Long id) {

        var result = service.execute(id);

        var response = StreamingMapper.toStreamingResponse(result);

        return ResponseEntity.ok(response);

    }

}
