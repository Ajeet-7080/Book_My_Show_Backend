package com.example.BookMyShowBackend.Dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {
    private int id;
    private String name;
    private LocalDate releaseDate;
    private List<ShowDto> movieShow;
}
