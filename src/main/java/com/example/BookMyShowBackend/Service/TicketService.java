package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.Dto.BookTicketRequestDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.TicketResponseDto;

public interface TicketService {

    TicketResponseDto getTicket(int id);

    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

}
