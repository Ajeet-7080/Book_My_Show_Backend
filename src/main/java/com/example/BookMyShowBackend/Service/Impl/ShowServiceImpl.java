package com.example.BookMyShowBackend.Service.Impl;

import com.example.BookMyShowBackend.Converter.ShowConverter;
import com.example.BookMyShowBackend.Dto.ShowDto;
import com.example.BookMyShowBackend.Models.*;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.ShowSeatRepository;
import com.example.BookMyShowBackend.Repository.TheaterRepository;
import com.example.BookMyShowBackend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShowServiceImpl implements ShowService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowDto addShow(ShowDto showDto) {
        ShowEntity showEntity= ShowConverter.dtoToEntity(showDto);
        MovieEntity movieEntity=movieRepository.findById(showDto.getMovieDto().getId()).get();
        showEntity.setMovie(movieEntity);

        TheaterEntity theaterEntity=theaterRepository.findById(showDto.getTheaterDto().getId()).get();
        showEntity.setTheater(theaterEntity);

        List<ShowSeatEntity> seats=createShowSeatEntity(theaterEntity.getSeats(),showEntity);
        showEntity.setSeats(seats);

        showRepository.save(showEntity);
        return showDto;

    }
    public List<ShowSeatEntity> createShowSeatEntity(List<TheaterSeatEntity> theaterSeats,ShowEntity show){
        List<ShowSeatEntity> showSeats=new ArrayList<>();
        for(TheaterSeatEntity seat:theaterSeats){
            ShowSeatEntity showSeat=ShowSeatEntity.builder().id(seat.getId()).seatNumber(seat.getSeatNumber()).seatType(seat.getSeatType()).build();

            showSeats.add(showSeat);
        }
        showSeatRepository.saveAll(showSeats);
        return showSeats;
    }
}
