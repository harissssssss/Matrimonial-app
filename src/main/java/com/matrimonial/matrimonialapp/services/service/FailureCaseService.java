package com.matrimonial.matrimonialapp.services.service;


import com.matrimonial.matrimonialapp.models.FailureCase;

import java.util.Optional;
import java.util.List;

public interface FailureCaseService {
    FailureCase createFailureCase(FailureCase failureCase);

    Optional<FailureCase> getFailureCaseById(Long id);

    List<FailureCase> getAllFailureCases();

    void deleteFailureCase(Long id);
}