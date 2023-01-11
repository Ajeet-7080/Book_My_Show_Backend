package com.example.BookMyShowBackend.Dto;

import com.example.BookMyShowBackend.Enum.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
    int id; // user id
    int showId;
    SeatType seatType;
    Set<String> requestedSeats;
}
