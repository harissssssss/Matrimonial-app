package com.matrimonial.matrimonialapp.util;

import com.matrimonial.matrimonialapp.models.Profile;
import com.matrimonial.matrimonialapp.models.Role;
import com.matrimonial.matrimonialapp.models.SubscriptionStatus;
import com.matrimonial.matrimonialapp.models.User;

import java.time.LocalDateTime;

public class CommonAdminUtil {

    // A static method that returns the common admin with a non-null profile
    public static User getCommonAdmin() {
        // Create a profile for the admin
        Profile adminProfile = new Profile();
        adminProfile.setProfileId(007L);
        adminProfile.setFirstName("Syed");
        adminProfile.setLastName("Mohd Haris");
        adminProfile.setMobileNumber("9654746105");
        adminProfile.setAge(26); // Example age
        adminProfile.setGender("M");
        adminProfile.setCaste("SYED");
        adminProfile.setReligion("Islam");
        adminProfile.setCity("Delhi");
        adminProfile.setEducation("Post Graduate");
        adminProfile.setOccupation("Software Engineering");
        adminProfile.setIncome(100000); // Example income
        adminProfile.setSubscriptionStatus(SubscriptionStatus.Registered);
        adminProfile.setApprovedByAdmin(true); // Admin profile is pre-approved
        adminProfile.setCreatedAt(LocalDateTime.now());

        // Create the admin user and associate it with the admin profile
        User adminUser = new User(007L, "Syed Mohd Haris", "Syed_Admin", "haris.play@example.com", "adminPassword", Role.ADMIN, adminProfile, LocalDateTime.now());

        // Set the profile's user field to reference the admin user (for bi-directional relationship)
        adminProfile.setUser(adminUser);

        return adminUser;
    }
}

