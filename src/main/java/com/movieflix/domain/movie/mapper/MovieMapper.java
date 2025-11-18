package com.movieflix.domain.movie.mapper;

import com.movieflix.domain.category.DTO.CategoryResponse;
import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.mapper.CategoryMapper;
import com.movieflix.domain.movie.dto.MovieRequest;
import com.movieflix.domain.movie.dto.MovieResponse;
import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.streaming.DTO.StreamingResponse;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.mapper.StreamingMapper;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request) {

        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streaming().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();


        return Movie
                .builder()
                .title(request.title())
                .description(request.description())
                .imgUrl(request.imgUrl())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories).streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {

        List<CategoryResponse> categories = movie.getCategories().stream()
                .map(category -> CategoryMapper.toCategoryResponse(category)).toList();

        List<StreamingResponse> streamings = movie.getStreamings().stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming)).toList();

        return MovieResponse
                .builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .imgUrl(movie.getImgUrl())
                .createdAt(movie.getCreatedAt())
                .updatedAt(movie.getUpdatedAt())
                .releaseDate(movie.getReleaseDate())
                .categoryResponseList(categories)
                .streamingResponseList(streamings)
                .build();
    }
}
