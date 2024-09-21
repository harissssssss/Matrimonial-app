package com.matrimonial.matrimonialapp.dto;
import com.matrimonial.matrimonialapp.Exceptions.Errors.Errors;
import com.matrimonial.matrimonialapp.models.Profile;
import com.matrimonial.matrimonialapp.models.ProfileStatus;
import com.matrimonial.matrimonialapp.models.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class InterestResponseDto {
    private Long interestId;
    private User user;
    private Profile profile;
    private ProfileStatus status;
    private LocalDateTime createdAt;
    private List<Errors> errors;

    // Getters and Setters

}

