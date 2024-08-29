package com.test.carparkinginvoicing.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String username;
    private String password;
    private String role;
    private LocalDateTime createdAt;
}
