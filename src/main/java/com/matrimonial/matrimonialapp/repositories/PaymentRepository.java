package com.matrimonial.matrimonialapp.repositories;

import com.matrimonial.matrimonialapp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // You can add custom query methods if needed
}