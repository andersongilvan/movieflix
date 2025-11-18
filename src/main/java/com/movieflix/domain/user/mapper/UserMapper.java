package com.movieflix.domain.user.mapper;


import com.movieflix.domain.user.DTO.UserRequest;
import com.movieflix.domain.user.DTO.UserResponse;
import com.movieflix.domain.user.entity.Users;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static Users toUser(UserRequest request) {
        return Users
                .builder()
                .name(request.name())
                .email(request.email())
                .hashPassword(request.password())
                .build();
    }

    public static UserResponse toUserResponse(Users user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();

    }

}
