package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.Dto.EntryDto.MovieEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShowBackend.Dto.ResponseDto.MovieResponseDto;

public interface MovieService {
    //Add movie
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);


    //get movie
    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);
}
