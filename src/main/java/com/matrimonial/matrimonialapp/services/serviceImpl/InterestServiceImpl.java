package com.matrimonial.matrimonialapp.services.serviceImpl;

import com.matrimonial.matrimonialapp.Exceptions.InterestNotFoundException;
import com.matrimonial.matrimonialapp.Exceptions.ProfileNotFoundException;
import com.matrimonial.matrimonialapp.Exceptions.UserNotFoundException;
import com.matrimonial.matrimonialapp.models.*;
import com.matrimonial.matrimonialapp.repositories.InterestRepository;
import com.matrimonial.matrimonialapp.services.service.CaseService;
import com.matrimonial.matrimonialapp.services.service.InterestService;
import com.matrimonial.matrimonialapp.services.service.ProfileService;
import com.matrimonial.matrimonialapp.services.service.UserService;
import com.matrimonial.matrimonialapp.util.CommonAdminUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestRepository interestRepository;

    @Autowired
    private CaseService caseService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

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

    @Override
    public Interest updateInterest(Interest interest) {
        return null;
    }

    @Override
    public Optional<Interest> findByUserIdAndProfileId(Long userId, Long profileId) {
        return interestRepository.findByUserIdAndProfileId(userId, profileId);
    }

//  #useId = 7, profileId = 3
//  #userId = 8, profileId = 4
    //they cannot like them Self we have to prevent this, for eg: userId =7 cannot like profileId = 3
    @Override
    @Transactional
    public Interest CreateInterestAndCase(Long userId, Long profileId) {
        // Fetch user, throw custom exception if not found
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        // Fetch profile, throw custom exception if not found
        Profile profile = profileService.getProfileById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile with ID " + profileId + " not found"));

        // Create a new Interest object
        Interest interest = new Interest();
        interest.setUser(user);
        interest.setProfile(profile);
        interest.setStatus(ProfileStatus.Pending);
        interest.setCreatedAt(LocalDateTime.now());

        // Save the interest to the database
        Interest savedInterest = createInterest(interest);

        // Step 2: Create a case for admin review
        Case newCase = new Case();
        newCase.setInterest(savedInterest);     // Associate the case with the interest
        newCase.setStatus(CaseStatus.Under_Review); // Initial status set to UNDER_REVIEW
        newCase.setCreatedAt(LocalDateTime.now());
        newCase.setAdmin(CommonAdminUtil.getCommonAdmin());

        // Save the case to the database
        caseService.createCase(newCase);
        return savedInterest;
    }

    @Override
    @Transactional
    public void undoInterest(Long userId, Long profileId) throws InterestNotFoundException {

        // Find the interest based on userId and profileId
        Optional<Interest> interestOpt = findByUserIdAndProfileId(userId, profileId);
        if (!interestOpt.isPresent()) {
            throw new InterestNotFoundException("Interest not found for userId " + userId + " and profileId " + profileId);
        }
        Interest interest = interestOpt.get();

        Optional<Case> caseOpt = caseService.findByInterestId(interest.getInterestId());
        if (caseOpt.isPresent()) {
            caseService.deleteCase(caseOpt.get().getCaseId());
        }
        interestRepository.delete(interest);
    }
}