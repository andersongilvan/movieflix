package com.movieflix.domain.movie.repository;


import com.movieflix.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("""
            SELECT m FROM Movie m
            JOIN m.categories c
            WHERE c.id = :idCategory
            """)
    Optional<List<Movie>>findByCategory(@Param("idCategory") Long idCategory);

}
