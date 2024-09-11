package com.matrimonial.matrimonialapp.services.service;


import com.matrimonial.matrimonialapp.models.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment createPayment(Payment payment);

    Optional<Payment> getPaymentById(Long id);

    List<Payment> getAllPayments();

    void deletePayment(Long id);
}