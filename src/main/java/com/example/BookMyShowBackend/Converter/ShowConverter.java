package com.example.BookMyShowBackend.Converter;

import com.example.BookMyShowBackend.Dto.ShowDto;
import com.example.BookMyShowBackend.Models.ShowEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    public static ShowEntity dtoToEntity(ShowDto showDto){
        return ShowEntity.builder().id(showDto.getId()).showTime(showDto.getShowTime()).showDate(showDto.getShowDate()).build();
    }
}
