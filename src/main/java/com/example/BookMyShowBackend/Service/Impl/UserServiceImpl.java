package com.example.BookMyShowBackend.Service.Impl;

import com.example.BookMyShowBackend.Converter.UserConverter;
import com.example.BookMyShowBackend.Dto.UserDto;
import com.example.BookMyShowBackend.Models.UserEntity;
import com.example.BookMyShowBackend.Repository.UserRepository;
import com.example.BookMyShowBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDto){
        UserEntity userEntity= UserConverter.dtoToEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }
    @Override
    public UserDto getUser(int id){
       UserEntity userEntity=userRepository.findById(id).get();
       UserDto userDto=UserConverter.entityToDto(userEntity);
       return userDto;
    }
}
