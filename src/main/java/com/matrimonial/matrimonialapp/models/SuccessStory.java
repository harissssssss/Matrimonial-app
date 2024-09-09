package com.matrimonial.matrimonialapp.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "success_stories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SuccessStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude // Prevent circular reference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    @ToString.Exclude // Prevent circular reference
    private Profile profile;

    @Column(length = 2000)
    private String description;

    private LocalDateTime createdAt;

    // Automatically set createdAt
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
