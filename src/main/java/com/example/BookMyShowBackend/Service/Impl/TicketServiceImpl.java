package com.example.BookMyShowBackend.Service.Impl;

import com.example.BookMyShowBackend.Converter.ShowConverter;
import com.example.BookMyShowBackend.Converter.TicketConverter;
import com.example.BookMyShowBackend.Converter.UserConverter;
import com.example.BookMyShowBackend.Dto.BookTicketRequestDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShowBackend.Models.ShowEntity;
import com.example.BookMyShowBackend.Models.ShowSeatEntity;
import com.example.BookMyShowBackend.Models.TicketEntity;
import com.example.BookMyShowBackend.Models.UserEntity;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.TicketRepository;
import com.example.BookMyShowBackend.Repository.UserRepository;
import com.example.BookMyShowBackend.Service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();

        UserConverter TicketConvertor;
        TicketResponseDto ticketResponseDto = TicketConverter.convertEntityToDto(ticketEntity);

        return ticketResponseDto;
    }

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        log.info("Ticket half processed");

        Set<String> requestSeats = bookTicketRequestDto.getRequestedSeats();


        List<ShowSeatEntity> showSeatsEntityList = showEntity.getSeats();

        // for(ShowSeatsEntity seat: showSeatsEntityList) System.out.print(seat+" ");


//        //Another way to iterate. Try to study about it.
//        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList
//                .stream()
//                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&!seat.isBooked()&&
//                        requestSeats.contains(seat.getSeatNumber()))
//                .collect(Collectors.toList());



        List<ShowSeatEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatEntity seat :showSeatsEntityList){

            if(!seat.isBooked()&&seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&requestSeats.contains(seat.getSeatNumber())){
                bookedSeats.add(seat);
            }
        }

        for(ShowSeatEntity seat: bookedSeats) System.out.println(seat);
        if(bookedSeats.size()!=requestSeats.size()){
            //All the seats were not avaiable
            throw new Error("All Seats not available");
        }

        //Step 2

        TicketEntity ticketEntity = TicketEntity.builder().
                user(userEntity)
                .show(showEntity)
                .seats(bookedSeats).
                build();



        //Step 3 :

        double amount = 0;

        for(ShowSeatEntity showSeatsEntity: bookedSeats){

            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookAt(new Date());
            showSeatsEntity.setTickets(ticketEntity);

            amount = amount + showSeatsEntity.getRate();
        }

        ticketEntity.setBookAt(new Date());
        ticketEntity.setAllotedSeats(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setAmount(amount);


        //Connect in thw Show and the user

        showEntity.getTickets().add(ticketEntity);


        //Add the ticket in the tickets list of the user Entity
        userEntity.getTicketEntities().add(ticketEntity);


        ticketEntity = ticketRepository.save(ticketEntity);

        ShowConverter TicketConvertor;
        return TicketConverter.convertEntityToDto(ticketEntity);



    }

    public String convertListOfSeatsEntityToString(List<ShowSeatEntity> bookedSeats){

        String str = "";
        for(ShowSeatEntity showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNumber()+" ";
        }

        return str;

    }
}
