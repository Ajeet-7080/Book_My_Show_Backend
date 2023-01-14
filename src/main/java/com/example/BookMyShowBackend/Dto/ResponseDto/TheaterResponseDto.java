package com.example.BookMyShowBackend.Dto.ResponseDto;

import com.example.BookMyShowBackend.Enum.TheaterType;
import com.sun.istack.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TheaterResponseDto {

    @NotNull
    int id;

    String name;
    String address;
    String city;
    TheaterType type;
}
