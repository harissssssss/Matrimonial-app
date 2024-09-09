package com.matrimonial.matrimonialapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private int age;
    private String gender;
    private String caste;
    private String religion;
    private String city;
    private String education;
    private String occupation;
    private int income;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;

    private boolean approvedByAdmin;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude // Prevent circular reference
    private User user;

    // Automatically set timestamps
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

