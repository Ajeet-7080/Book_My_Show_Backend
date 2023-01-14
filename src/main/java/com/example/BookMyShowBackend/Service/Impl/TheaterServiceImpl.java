package com.example.BookMyShowBackend.Service.Impl;

import com.example.BookMyShowBackend.Converter.TheaterConverter;
import com.example.BookMyShowBackend.Dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.TheaterResponseDto;
import com.example.BookMyShowBackend.Enum.SeatType;
import com.example.BookMyShowBackend.Enum.TheaterType;
import com.example.BookMyShowBackend.Models.TheaterEntity;
import com.example.BookMyShowBackend.Models.TheaterSeatEntity;
import com.example.BookMyShowBackend.Repository.TheaterRepository;
import com.example.BookMyShowBackend.Repository.TheaterSeatRepository;
import com.example.BookMyShowBackend.Service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {

        TheaterEntity theaterEntity= TheaterConverter.convertDtoToEntity(theaterEntryDto);

        // Create the seat
        // we have declared a list of theater seats
        List<TheaterSeatEntity> seats=createTheaterSeats();

        theaterEntity.setSeats(seats);
        // I need to set theatre id for all these seats

        theaterEntity.setShows(null);

        for(TheaterSeatEntity theaterSeatEntity:seats){
            theaterSeatEntity.setTheater(theaterEntity);
        }

        theaterEntity.setType(TheaterType.SINGLE);

        log.info("The theater entity is "+ theaterEntity);

        theaterEntity = theaterRepository.save(theaterEntity);
        theaterSeatRepository.saveAll(seats);

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);


        return theaterResponseDto;
    }
    // here implementing the createListFunction()
    List<TheaterSeatEntity>createTheaterSeats(){

        List<TheaterSeatEntity>seats=new ArrayList<>();

        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("2A",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E",100,SeatType.PREMIUM));

        return seats;

    }
    // here implementing get Theatre seat function

        TheaterSeatEntity getTheaterSeat(String seatNo, int rate, SeatType seatType){

            return TheaterSeatEntity.builder().seatNumber(seatNo).rate(rate).seatType(seatType).build();
        }





    @Override
    public TheaterResponseDto getTheater(int id) {

        TheaterEntity theaterEntity = theaterRepository.findById(id).get();

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterResponseDto;
    }
}
