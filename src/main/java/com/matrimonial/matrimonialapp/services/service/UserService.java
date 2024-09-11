package com.matrimonial.matrimonialapp.services.service;


import com.matrimonial.matrimonialapp.models.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByUserName(String userName);

    Optional<User> getUserByEmail(String email);

    void deleteUser(Long id);
}