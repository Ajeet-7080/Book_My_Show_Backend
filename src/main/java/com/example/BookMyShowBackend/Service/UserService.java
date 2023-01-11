package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.Dto.UserDto;

public interface UserService {
    // get
    public UserDto addUser(UserDto useDto);
    // add
    public UserDto getUser(int id);
}
