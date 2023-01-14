package com.example.BookMyShowBackend.Service.Impl;

import com.example.BookMyShowBackend.Converter.UserConverter;
import com.example.BookMyShowBackend.Dto.EntryDto.UserEntryDto;
import com.example.BookMyShowBackend.Dto.ResponseDto.UserResponseDto;
import com.example.BookMyShowBackend.Models.UserEntity;
import com.example.BookMyShowBackend.Repository.UserRepository;
import com.example.BookMyShowBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public void addUser(UserEntryDto userEntryDto) {
        UserEntity userEntity= UserConverter.convertDtoToEntity(userEntryDto);

        // save the user record in the database
        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {
        UserEntity user=new UserEntity(); // by default user
       UserEntity userEntity=userRepository.findById(id).get();

        UserResponseDto userResponseDto=UserConverter.convertEntityToDto(userEntity);

        return userResponseDto;
    }
}
