package com.example.BookMyShowBackend.Dto;

import com.example.BookMyShowBackend.Dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TicketDto {

    int id;

    String alloted_seats;

    double amount;

    ShowResponseDto showDto;

    @NotNull
    UserResponseDto userDto;
}
