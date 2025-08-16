package com.icps.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String policyNumber;
    private String claimType;
    private String description;
    private LocalDate claimDate;
    private Double claimAmount;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate submittedDate;

    // Getters and setters
    public Claim() {
        super();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    public String getClaimType() {
        return claimType;
    }
    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getClaimDate() {
        return claimDate;
    }
    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }
    public Double getClaimAmount() {
        return claimAmount;
    }
    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public LocalDate getSubmittedDate() {
        return submittedDate;
    }
    public void setSubmittedDate(LocalDate submittedDate) {
        this.submittedDate = submittedDate;
    }

}
