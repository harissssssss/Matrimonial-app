package com.matrimonial.matrimonialapp.controllers;

import com.matrimonial.matrimonialapp.Exceptions.InterestNotFoundException;
import com.matrimonial.matrimonialapp.models.Interest;
import com.matrimonial.matrimonialapp.services.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interests")
public class InterestController {

    @Autowired
    private InterestService interestService;

    // Step 1: User likes a profile (Create new interest and case)
    @PostMapping("/like")
    public ResponseEntity<Interest> likeProfile(@RequestParam Long userId, @RequestParam Long profileId) {
        Interest savedInterestAndCase = interestService.CreateInterestAndCase(userId, profileId);
        return ResponseEntity.ok(savedInterestAndCase);
    }

    @DeleteMapping("/undo")
    public ResponseEntity<String> undoInterest(@RequestParam Long userId, @RequestParam Long profileId) {
        try {
            interestService.undoInterest(userId, profileId);
            return ResponseEntity.ok("Interest has been undone and case updated with a note.");
        } catch (InterestNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
