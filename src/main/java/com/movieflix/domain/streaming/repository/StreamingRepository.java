package com.movieflix.domain.streaming.repository;

import com.movieflix.domain.streaming.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;


@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {

    @Query(
            value = "SELECT * FROM streaming WHERE LOWER(title) = LOWER(:title)",
            nativeQuery = true
    )
    Optional<Streaming> findStreamingByTitle(@Param("title") String title);

    List<Streaming> findAllByOrderByTitleAsc();
}
