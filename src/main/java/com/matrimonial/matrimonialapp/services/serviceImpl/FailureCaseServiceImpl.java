package com.matrimonial.matrimonialapp.services.serviceImpl;

import com.matrimonial.matrimonialapp.models.FailureCase;
import com.matrimonial.matrimonialapp.repositories.FailureCaseRepository;
import com.matrimonial.matrimonialapp.services.service.FailureCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FailureCaseServiceImpl implements FailureCaseService {

    @Autowired
    private FailureCaseRepository failureCaseRepository;

    @Override
    public FailureCase createFailureCase(FailureCase failureCase) {
        return failureCaseRepository.save(failureCase);
    }

    @Override
    public Optional<FailureCase> getFailureCaseById(Long id) {
        return failureCaseRepository.findById(id);
    }

    @Override
    public List<FailureCase> getAllFailureCases() {
        return failureCaseRepository.findAll();
    }

    @Override
    public void deleteFailureCase(Long id) {
        failureCaseRepository.deleteById(id);
    }
}