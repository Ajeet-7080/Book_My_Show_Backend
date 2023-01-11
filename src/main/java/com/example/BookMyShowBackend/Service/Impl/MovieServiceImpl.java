package com.example.BookMyShowBackend.Service.Impl;

import com.example.BookMyShowBackend.Converter.MovieConverter;
import com.example.BookMyShowBackend.Dto.MovieDto;
import com.example.BookMyShowBackend.Models.MovieEntity;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import com.example.BookMyShowBackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public void addMovie(MovieDto movieDto){
        MovieEntity movieEntity= MovieConverter.dtoToEntity(movieDto);
        movieRepository.save(movieEntity);
    }

    @Override
    public MovieDto getMovie(int id) {
        MovieEntity movieEntity=movieRepository.findById(id).get();
        MovieDto movieDto=MovieConverter.entityToDto(movieEntity);
        return movieDto;
    }
}
