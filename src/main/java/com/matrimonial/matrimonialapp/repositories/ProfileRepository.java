package com.matrimonial.matrimonialapp.repositories;

import com.matrimonial.matrimonialapp.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // You can add custom query methods if needed
}
