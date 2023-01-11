package com.example.BookMyShowBackend.Service;


import com.example.BookMyShowBackend.Dto.MovieDto;

public interface MovieService {
    // a function to set Movie
    void addMovie(MovieDto movieDto);

    // a function to geṭ  movie
    MovieDto getMovie(int id);
}
