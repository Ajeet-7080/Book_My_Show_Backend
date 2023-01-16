package com.example.BookMyShowBackend.Dto.ResponseDto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieNameAndIdObject {
    int id;
    String name;
}
