package com.example.BookMyShowBackend.Dto.ResponseDto;

import com.example.BookMyShowBackend.Dto.TicketDto;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    int id;
    String name;
    String mobNo;

    //optional
    List<TicketDto> tickets;
}
