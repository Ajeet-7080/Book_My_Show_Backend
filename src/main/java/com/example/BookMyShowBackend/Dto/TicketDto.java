package com.example.BookMyShowBackend.Dto;

import java.util.Set;

public class TicketDto {
    int id;
    Set<String> allotedSeats;
    double amount;

    ShowDto showDto;
    UserDto userDto;
}
