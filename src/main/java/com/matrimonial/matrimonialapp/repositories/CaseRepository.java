package com.matrimonial.matrimonialapp.repositories;

import com.matrimonial.matrimonialapp.models.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
    // You can add custom query methods if needed
}