package com.matrimonial.matrimonialapp.dto;

import com.matrimonial.matrimonialapp.models.SubscriptionStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProfileResponseDto {
    private int profileId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private int age;
    private String gender;
    private String caste;
    private String religion;
    private String city;
    private String education;
    private String occupation;
    private int income;
    private SubscriptionStatus subscriptionStatus;
    private boolean approvedByAdmin;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private UserDto user;
}
