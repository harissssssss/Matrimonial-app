package com.matrimonial.matrimonialapp.models;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interest_id", nullable = false)
    @ToString.Exclude // Prevent circular reference
    private Interest interest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", nullable = false)
    @ToString.Exclude // Prevent circular reference
    private User admin;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String notes;

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
