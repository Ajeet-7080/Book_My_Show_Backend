package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.Dto.BookRequestDto;
import com.example.BookMyShowBackend.Dto.TicketDto;

public interface TicketService {
    // get by Id

    // book
    public TicketDto bookTicket(BookRequestDto bookRequestDto);
}
