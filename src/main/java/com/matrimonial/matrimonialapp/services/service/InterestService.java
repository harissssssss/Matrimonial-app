package com.matrimonial.matrimonialapp.services.service;

import com.matrimonial.matrimonialapp.Exceptions.InterestNotFoundException;
import com.matrimonial.matrimonialapp.models.Interest;

import java.util.List;
import java.util.Optional;

public interface InterestService {
    Interest createInterest(Interest interest);

    Optional<Interest> getInterestById(Long id);

    List<Interest> getAllInterests();

    void deleteInterest(Long id);

    Interest updateInterest(Interest interest);

    Interest CreateInterestAndCase(Long userId, Long profileId);

    void undoInterest(Long userId, Long profileId) throws InterestNotFoundException;

    Optional<Interest> findByUserIdAndProfileId(Long userId, Long profileId);
}