package com.example.BookMyShowBackend.Converter;

import com.example.BookMyShowBackend.Dto.EntryDto.UserEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.UserResponseDto;
import com.example.BookMyShowBackend.Models.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){
        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobNo()).build();
    }


    public static UserResponseDto convertEntityToDto(UserEntity userEntity) {
        return UserResponseDto.builder().id(userEntity.getId()).name(userEntity.getName()).mobNo(userEntity.getMobile()).build();
    }
}
