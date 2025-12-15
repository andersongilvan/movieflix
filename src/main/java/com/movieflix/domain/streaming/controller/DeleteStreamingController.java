package com.movieflix.domain.streaming.controller;


import com.movieflix.domain.streaming.services.DeleteStreamingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/streaming")
public class DeleteStreamingController {

    @Autowired
    private DeleteStreamingService deleteStreamingService;

    @DeleteMapping("/{id}")
    @Tag(
            name = "Delete streaming",
            description = "Endpoint for delete a streaming"
    )
    public ResponseEntity<Void> handler(@PathVariable Long id) {

        deleteStreamingService.delete(id);

        return ResponseEntity.noContent().build();

    }

}
