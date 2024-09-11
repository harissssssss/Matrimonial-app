package com.matrimonial.matrimonialapp.repositories;

import com.matrimonial.matrimonialapp.models.SuccessStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuccessStoryRepository extends JpaRepository<SuccessStory, Long> {
    // You can add custom query methods if needed
}
