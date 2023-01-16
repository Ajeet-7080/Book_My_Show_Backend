package com.example.BookMyShowBackend.Dto.ResponseDto;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto {
    @NotNull
    int id;

    String name;

    LocalDate releaseDate;

    //Optional
    List<ShowResponseDto> showDtoList;
}
