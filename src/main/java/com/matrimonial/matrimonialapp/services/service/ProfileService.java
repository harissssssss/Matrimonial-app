package com.matrimonial.matrimonialapp.services.service;

import com.matrimonial.matrimonialapp.models.Profile;

import java.util.Optional;

public interface ProfileService {
    Profile createProfile(Profile profile);

    Optional<Profile> getProfileById(Long id);

    void deleteProfile(Long id);
}