package com.example.BookMyShowBackend.Service;


import com.example.BookMyShowBackend.Dto.EntryDto.UserEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.UserResponseDto;

public interface UserService {
        //adding a new user
        void addUser(UserEntryDto userEntryDto);

        // find an existing user through user id
        UserResponseDto getUser(int id);
}
