package com.example.BookMyShowBackend.Service.Impl;

import com.example.BookMyShowBackend.Converter.TheaterConverter;
import com.example.BookMyShowBackend.Dto.TheaterDto;
import com.example.BookMyShowBackend.Enum.SeatType;
import com.example.BookMyShowBackend.Models.TheaterEntity;
import com.example.BookMyShowBackend.Models.TheaterSeatEntity;
import com.example.BookMyShowBackend.Repository.TheaterRepository;
import com.example.BookMyShowBackend.Repository.TheaterSeatRepository;
import com.example.BookMyShowBackend.Service.TheaterService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TheaterServiceImpl implements TheaterService {
    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public void addTheater(TheaterDto theaterDto) {
        TheaterEntity theaterEntity= TheaterConverter.dtoToEntity(theaterDto);
        List<TheaterSeatEntity> seat=createTheaterSeats();
        for(TheaterSeatEntity theaterSeat:seat){
            theaterSeat.setTheater(theaterEntity);
        }
        theaterRepository.save(theaterEntity);
    }
    public List<TheaterSeatEntity> createTheaterSeats(){
        List<TheaterSeatEntity>seats=new ArrayList<>();
        seats.add(getTheaterSeat("A10",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("A11",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("A12",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("B10",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("B12",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("B13",100,SeatType.PREMIUM));

        theaterSeatRepository.saveAll(seats);
        return seats;
    }
    public TheaterSeatEntity getTheaterSeat(String seatNo, int rate, SeatType seatType){
        return TheaterSeatEntity.builder().seatNumber(seatNo).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheaterDto getTheater(int id) {
        TheaterEntity theaterEntity=theaterRepository.findById(id).get();
        TheaterDto theaterDto=TheaterConverter.entityToDto(theaterEntity);
        return theaterDto;
    }
}
