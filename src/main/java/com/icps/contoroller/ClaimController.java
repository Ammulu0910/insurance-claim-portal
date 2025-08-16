package com.icps.controller;

import com.icps.entity.Claim;
import com.icps.entity.Status;
import com.icps.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimRepository claimRepository;

    // 1st POST method
    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        Claim savedClaim = claimRepository.save(claim);
        return new ResponseEntity<>(savedClaim, HttpStatus.CREATED);
    } // ← THIS WAS MISSING

    // 2nd POST method
    @PostMapping("/create")
    public Claim submitClaim(@RequestBody Claim claim) {
        claim.setStatus(Status.PENDING);
        claim.setSubmittedDate(LocalDate.now());
        return claimRepository.save(claim);
    }

    @GetMapping
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return claimRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}/status")
    public Claim updateStatus(@PathVariable Long id, @RequestParam Status status) {
        Claim claim = claimRepository.findById(id).orElseThrow();
        claim.setStatus(status);
        return claimRepository.save(claim);
    }
}
