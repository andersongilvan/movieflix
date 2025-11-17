package com.movieflix.domain.streaming.mapper;

import com.movieflix.domain.streaming.DTO.StreamingRequest;
import com.movieflix.domain.streaming.DTO.StreamingResponse;
import com.movieflix.domain.streaming.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request) {
        return Streaming
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }

}
