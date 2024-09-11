package com.matrimonial.matrimonialapp.services.serviceImpl;

import com.matrimonial.matrimonialapp.models.Profile;
import com.matrimonial.matrimonialapp.models.User;
import com.matrimonial.matrimonialapp.repositories.UserRepository;
import com.matrimonial.matrimonialapp.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        Profile profile = user.getProfile();

        // Set the bidirectional reference
        if (profile != null) {
            profile.setUser(user);  // Set the user in the profile
        }
        // Save the user and profile together because of CascadeType.ALL
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}