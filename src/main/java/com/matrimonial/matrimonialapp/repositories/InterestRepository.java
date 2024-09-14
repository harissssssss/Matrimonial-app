package com.matrimonial.matrimonialapp.repositories;

import com.matrimonial.matrimonialapp.models.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    @Query(value = "SELECT * FROM interests WHERE user_id = :userId AND profile_id = :profileId", nativeQuery = true)
    Optional<Interest> findByUserIdAndProfileId(@Param("userId") Long userId, @Param("profileId") Long profileId);

}
