package com.example.BookMyShowBackend.Dto.EntryDto;


import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntryDto {
    String name;

    @NotNull
    LocalDate releaseDate;

}
