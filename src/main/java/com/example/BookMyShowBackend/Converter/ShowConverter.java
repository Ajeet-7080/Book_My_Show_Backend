package com.example.BookMyShowBackend.Converter;

import com.example.BookMyShowBackend.Dto.EntryDto.ShowEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShowBackend.Models.ShowEntity;

public class ShowConverter {
    public static ShowEntity convertDtoToEntity(ShowEntryDto showDto) {

        return ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime())
                .build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity, ShowEntryDto showEntryDto){

        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theaterDto(showEntryDto.getTheaterResponseDto())
                .build();
    }
}
