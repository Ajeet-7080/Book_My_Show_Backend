package com.example.BookMyShowBackend.Converter;

import com.example.BookMyShowBackend.Dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.TheaterResponseDto;
import com.example.BookMyShowBackend.Models.TheaterEntity;
import lombok.experimental.UtilityClass;


@UtilityClass
public class TheaterConverter {
    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto) {
        return TheaterEntity.builder().name(theaterEntryDto.getName()).address(theaterEntryDto.getAddress()).city(theaterEntryDto.getCity()).build();
    }

    public static TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity) {
        return TheaterResponseDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .city(theaterEntity.getCity()).address(theaterEntity.getAddress())
                .type(theaterEntity.getType())
                .build();
    }
}
