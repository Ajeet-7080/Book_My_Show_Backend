package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.Dto.TheaterDto;

public interface TheaterService {
    void addTheater(TheaterDto theaterDto);
    TheaterDto getTheater(int id);
}
