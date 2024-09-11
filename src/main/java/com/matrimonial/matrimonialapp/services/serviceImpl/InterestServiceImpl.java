package com.matrimonial.matrimonialapp.services.serviceImpl;

import com.matrimonial.matrimonialapp.models.Interest;
import com.matrimonial.matrimonialapp.repositories.InterestRepository;
import com.matrimonial.matrimonialapp.services.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestRepository interestRepository;

    @Override
    public Interest createInterest(Interest interest) {
        return interestRepository.save(interest);
    }

    @Override
    public Optional<Interest> getInterestById(Long id) {
        return interestRepository.findById(id);
    }

    @Override
    public List<Interest> getAllInterests() {
        return interestRepository.findAll();
    }

    @Override
    public void deleteInterest(Long id) {
        interestRepository.deleteById(id);
    }
}