package com.matrimonial.matrimonialapp.dto;

import com.matrimonial.matrimonialapp.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private ProfileResponseDto profile;
    private LocalDateTime createdAt;
}
