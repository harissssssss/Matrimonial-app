package com.matrimonial.matrimonialapp.services.serviceImpl;

import com.matrimonial.matrimonialapp.models.Profile;
import com.matrimonial.matrimonialapp.repositories.ProfileRepository;
import com.matrimonial.matrimonialapp.services.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
