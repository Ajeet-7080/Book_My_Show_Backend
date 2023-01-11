package com.example.BookMyShowBackend.Converter;

import com.example.BookMyShowBackend.Dto.TheaterDto;
import com.example.BookMyShowBackend.Models.TheaterEntity;
import lombok.experimental.UtilityClass;

@UtilityClass

public class TheaterConverter {
    public static TheaterEntity dtoToEntity(TheaterDto theaterDto) {
        return TheaterEntity.builder().id(theaterDto.getId()).address(theaterDto.getAddress()).city(theaterDto.getCity())
                .name(theaterDto.getName()).type(theaterDto.getTheaterType()).build();
    }

    public static TheaterDto entityToDto(TheaterEntity theaterEntity){
        return TheaterDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName()).city(theaterEntity.getCity()).
                address(theaterEntity.getAddress()).build();
    }
}
