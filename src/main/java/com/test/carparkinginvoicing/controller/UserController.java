package com.test.carparkinginvoicing.controller;

import com.test.carparkinginvoicing.dto.UserDto;
import com.test.carparkinginvoicing.entity.User;
import com.test.carparkinginvoicing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody LoginDto loginDTO) {
//        User foundUser = userService.findByUsername(loginDTO.getUsername());
//        if (foundUser != null && new BCryptPasswordEncoder().matches(loginDTO.getPassword(), foundUser.getPassword())) {
//            return ResponseEntity.ok(foundUser);
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDto userDTO) {
        User savedUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
