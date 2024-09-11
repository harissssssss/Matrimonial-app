package com.matrimonial.matrimonialapp.services.service;

import com.matrimonial.matrimonialapp.models.Interest;

import java.util.List;
import java.util.Optional;

public interface InterestService {
    Interest createInterest(Interest interest);

    Optional<Interest> getInterestById(Long id);

    List<Interest> getAllInterests();

    void deleteInterest(Long id);
}