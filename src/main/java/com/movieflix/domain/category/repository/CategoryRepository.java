package com.movieflix.domain.category.repository;

import com.movieflix.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(
            value = "SELECT * FROM category WHERE LOWER(title) = LOWER(:title)",
            nativeQuery = true
    )
    Optional<Category> findCategoryByTitle(@Param("title") String title);

}
