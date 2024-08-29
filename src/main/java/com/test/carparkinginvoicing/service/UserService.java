package com.test.carparkinginvoicing.service;

import com.test.carparkinginvoicing.dto.UserDto;
import com.test.carparkinginvoicing.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(UserDto userDto);

    User updateUser(Long id, UserDto userDto);

    List<User> getAllUsers();

    User findByUsername(String username);

    void deleteUser(Long id);
}
