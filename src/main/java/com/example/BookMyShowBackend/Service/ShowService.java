package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.Dto.EntryDto.ShowEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.ShowResponseDto;

public interface ShowService {
    //Add show
    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    // get Show

}
