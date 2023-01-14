package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.Dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.TheaterResponseDto;

public interface TheaterService {


    TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);

    TheaterResponseDto getTheater(int id);
}
