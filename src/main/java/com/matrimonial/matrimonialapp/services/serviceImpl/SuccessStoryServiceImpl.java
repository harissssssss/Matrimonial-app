package com.matrimonial.matrimonialapp.services.serviceImpl;

import com.matrimonial.matrimonialapp.models.SuccessStory;
import com.matrimonial.matrimonialapp.repositories.SuccessStoryRepository;
import com.matrimonial.matrimonialapp.services.service.SuccessStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuccessStoryServiceImpl implements SuccessStoryService {

    @Autowired
    private SuccessStoryRepository successStoryRepository;

    @Override
    public SuccessStory createSuccessStory(SuccessStory successStory) {
        return successStoryRepository.save(successStory);
    }

    @Override
    public Optional<SuccessStory> getSuccessStoryById(Long id) {
        return successStoryRepository.findById(id);
    }

    @Override
    public List<SuccessStory> getAllSuccessStories() {
        return successStoryRepository.findAll();
    }

    @Override
    public void deleteSuccessStory(Long id) {
        successStoryRepository.deleteById(id);
    }
}