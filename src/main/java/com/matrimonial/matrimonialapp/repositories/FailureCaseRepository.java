package com.matrimonial.matrimonialapp.repositories;

import com.matrimonial.matrimonialapp.models.FailureCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FailureCaseRepository extends JpaRepository<FailureCase, Long> {
    // You can add custom query methods if needed
}
