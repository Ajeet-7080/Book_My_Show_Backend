package com.example.BookMyShowBackend.Service.Impl;

import com.example.BookMyShowBackend.Converter.MovieConverter;
import com.example.BookMyShowBackend.Dto.EntryDto.MovieEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShowBackend.Dto.ResponseDto.MovieResponseDto;
import com.example.BookMyShowBackend.Models.MovieEntity;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import com.example.BookMyShowBackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {

        MovieResponseDto movieResponseDto=null;

        if(movieRepository.existsByName(movieEntryDto.getName())){
            movieResponseDto.setName("this movie is already existing");
            return movieResponseDto;
        }

        // add movie in the database
        MovieEntity movieEntity= MovieConverter.convertDtoToEntity(movieEntryDto);

        movieEntity=movieRepository.save(movieEntity);

        movieResponseDto=MovieConverter.convertEntityToDto(movieEntity);

        return movieResponseDto;

    }

    @Override
    public MovieResponseDto getMovie(int id) {
        MovieEntity movieEntity=movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto=MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;
    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id) {
        // i need information from repo
        MovieEntity movieEntity=movieRepository.findById(id).get(); // get this movie entity form  database

        // I have to convert it
        MovieNameAndIdObject obj=MovieConverter.convertEntityToThisObject(movieEntity);
        return obj;
    }
}
