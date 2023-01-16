package com.example.BookMyShowBackend.Converter;

import com.example.BookMyShowBackend.Dto.EntryDto.MovieEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShowBackend.Dto.ResponseDto.MovieResponseDto;
import com.example.BookMyShowBackend.Models.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {
    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto) {
        return MovieEntity.builder().name(movieEntryDto.getName()).releaseDate(movieEntryDto.getReleaseDate()).build();
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity) {
        return MovieResponseDto.builder().id(movieEntity.getId()).name(movieEntity.getName()).releaseDate(movieEntity.getReleaseDate()).build();
    }

    public static MovieNameAndIdObject convertEntityToThisObject(MovieEntity movieEntity) {
        return MovieNameAndIdObject.builder().id(movieEntity.getId()).name(movieEntity.getName()).build();
    }
}
