package com.matrimonial.matrimonialapp.services.serviceImpl;

import com.matrimonial.matrimonialapp.models.Case;
import com.matrimonial.matrimonialapp.repositories.CaseRepository;
import com.matrimonial.matrimonialapp.services.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Override
    public Case createCase(Case caseData) {
        return caseRepository.save(caseData);
    }

    @Override
    public Optional<Case> getCaseById(Long id) {
        return caseRepository.findById(id);
    }

    @Override
    public void deleteCase(Long id) {
        caseRepository.deleteById(id);
    }

    @Override
    public void updateCase(Case caseData) {
        caseRepository.save(caseData);
    }

    @Override
    public Optional<Case> findByInterestId(Long interestId) {
        return caseRepository.findByInterest_InterestId(interestId);
    }
}
