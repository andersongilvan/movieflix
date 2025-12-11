package com.movieflix.domain.streaming.mapper;


import com.movieflix.domain.streaming.entity.Streaming;
import com.movieflix.domain.streaming.request.StreamingRequest;
import com.movieflix.domain.streaming.response.StreamingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming
                .builder()
                .title(streamingRequest.title())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .title(streaming.getTitle())
                .build();
    }

}
