package com.example.BookMyShowBackend.Converter;

import com.example.BookMyShowBackend.Dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShowBackend.Models.TicketEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {
    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity){

        return TicketResponseDto.builder().id((int) ticketEntity.getId()).amount(ticketEntity.getAmount())
                .alloted_seats(ticketEntity.getAllotedSeats())
                .build();

    }
}
