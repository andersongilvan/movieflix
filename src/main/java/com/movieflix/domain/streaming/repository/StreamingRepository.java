package com.movieflix.domain.streaming.repository;


import com.movieflix.domain.streaming.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {
    Streaming findByName(String name);
}
