package com.matrimonial.matrimonialapp.services.service;

import com.matrimonial.matrimonialapp.models.Case;

import java.util.Optional;

public interface CaseService {
    Case createCase(Case caseData);

    Optional<Case> getCaseById(Long id);

    void deleteCase(Long id);

    void updateCase(Case caseData);

    Optional<Case> findByInterestId(Long interestId);
}