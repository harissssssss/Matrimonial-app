package com.matrimonial.matrimonialapp.repositories;

import com.matrimonial.matrimonialapp.models.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaseRepository extends JpaRepository<Case, Long> {
    Optional<Case> findByInterest_InterestId(Long interestId);

    // You can add custom query methods if needed
//
//    @Query(value = "SELECT * FROM cases WHERE interest_id = :interestId", nativeQuery = true)
//    Optional<Case> findByInterestId(@Param("interestId") Long interestId);
}