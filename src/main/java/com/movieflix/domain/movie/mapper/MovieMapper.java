package com.movieflix.domain.movie.mapper;


import com.movieflix.domain.category.CategoryMapper;
import com.movieflix.domain.category.entity.Category;
import com.movieflix.domain.category.response.CategoryResponse;
import com.movieflix.domain.movie.entity.Movie;
import com.movieflix.domain.movie.request.MovieRequest;
import com.movieflix.domain.movie.response.MovieResponse;
import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.mapper.StreamingMapper;
import com.movieflix.domain.streaming.response.StreamingResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest movieRequest) {

        List<Category> categoryList = movieRequest.categories()
                .stream()
                .map(categoryId -> Category.builder().id(categoryId).build()).toList();

        List<Streaming> streamingList = movieRequest.streamings()
                .stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build()).toList();

        return Movie
                .builder()
                .title(movieRequest.title())
                .description(movieRequest.description())
                .releaseDate(movieRequest.releaseDate())
                .rating(movieRequest.rating())
                .categories(categoryList)
                .streamings(streamingList)
                .build();

    }

    public static MovieResponse toMovieResponse(Movie movie) {

        List<CategoryResponse> categoryResponseList = movie.getCategories()
                .stream()
                .map(category -> CategoryMapper.toCategoryResponse(category)).toList();

        List<StreamingResponse> streamingResponseList = movie.getStreamings()
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming)).toList();

        return MovieResponse
                .builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .createdAt(movie.getCreatedAt())
                .updatedAt(movie.getUpdatedAt())
                .categoryResponses(categoryResponseList)
                .streamingResponses(streamingResponseList)
                .build();
    }

}
