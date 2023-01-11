package com.example.BookMyShowBackend.Converter;

import com.example.BookMyShowBackend.Dto.UserDto;
import com.example.BookMyShowBackend.Models.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class UserConverter {
    public static UserEntity dtoToEntity(UserDto userDto){
        return UserEntity.builder().name(userDto.getName()).mobile(userDto.getMobile()).build();
    }

    public static UserDto entityToDto(UserEntity userEntity){
        return UserDto.builder().name(userEntity.getName()).mobile(userEntity.getMobile()).build();
    }
}
