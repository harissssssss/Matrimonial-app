package com.matrimonial.matrimonialapp.repositories;

import com.matrimonial.matrimonialapp.models.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    // You can add custom query methods if needed
}
