package com.example.BookMyShowBackend.Dto;

import com.example.BookMyShowBackend.Enum.TheaterType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterDto {

    private int id;
    private String name;
    private String city;
    private String  address;
    TheaterType theaterType;
    ShowDto showDto;
}
