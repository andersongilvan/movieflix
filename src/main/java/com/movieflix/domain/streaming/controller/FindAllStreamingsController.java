package com.movieflix.domain.streaming.controller;


import com.movieflix.domain.streaming.DTO.StreamingResponse;
import com.movieflix.domain.streaming.mapper.StreamingMapper;
import com.movieflix.domain.streaming.service.FindAllStreamingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/streaming")
public class FindAllStreamingsController {

    @Autowired
    private FindAllStreamingsService service;

    @GetMapping
    public ResponseEntity<Page<StreamingResponse>> handler(@PageableDefault(size = 20)Pageable pageable) {

        var pageResponse = service.execute(pageable)
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming));

        return ResponseEntity.ok(pageResponse);
    }
}
