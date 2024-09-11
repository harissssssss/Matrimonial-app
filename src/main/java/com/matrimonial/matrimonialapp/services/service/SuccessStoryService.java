package com.matrimonial.matrimonialapp.services.service;

import com.matrimonial.matrimonialapp.models.SuccessStory;

import java.util.Optional;
import java.util.List;

public interface SuccessStoryService {
    SuccessStory createSuccessStory(SuccessStory successStory);

    Optional<SuccessStory> getSuccessStoryById(Long id);

    List<SuccessStory> getAllSuccessStories();

    void deleteSuccessStory(Long id);
}