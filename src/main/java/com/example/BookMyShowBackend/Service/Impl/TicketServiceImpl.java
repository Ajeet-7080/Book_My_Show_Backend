package com.example.BookMyShowBackend.Service.Impl;

import com.example.BookMyShowBackend.Dto.BookRequestDto;
import com.example.BookMyShowBackend.Dto.TicketDto;
import com.example.BookMyShowBackend.Enum.SeatType;
import com.example.BookMyShowBackend.Models.ShowEntity;
import com.example.BookMyShowBackend.Models.UserEntity;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.UserRepository;
import com.example.BookMyShowBackend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class TicketServiceImpl implements TicketService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;

    @Override
    public TicketDto bookTicket(BookRequestDto bookRequestDto) {
        UserEntity userEntity=userRepository.findById(bookRequestDto.getId()).get();
        ShowEntity showEntity=showRepository.findById(bookRequestDto.getShowId()).get();

        SeatType seatType=bookRequestDto.getSeatType();
        Set<String> requestSeats=

        // check weather seat available or not

    }
}
