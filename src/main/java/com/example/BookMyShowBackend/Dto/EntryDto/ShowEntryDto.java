package com.example.BookMyShowBackend.Dto.EntryDto;

import com.example.BookMyShowBackend.Dto.ResponseDto.MovieResponseDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.TheaterResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Builder
public class ShowEntryDto {

    @NotNull
    LocalDate showDate;

    @NotNull
    LocalTime showTime;

    @NotNull
    MovieResponseDto movieResponseDto;

    @NotNull
    TheaterResponseDto theaterResponseDto;
}
