package com.example.springredditclone.controller;

import com.example.springredditclone.dto.PolicyRequest;
import com.example.springredditclone.dto.PolicyResponse;
import com.example.springredditclone.service.PolicyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/policy")
@AllArgsConstructor
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping
    public ResponseEntity<Void> createPolicy(@RequestBody PolicyRequest policyRequest) {
        policyService.save(policyRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PolicyResponse>> getAllPolicies() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(policyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponse> getPolicy(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(policyService.getPolicy(id));
    }

    @GetMapping("/by-product/{id}")
    public ResponseEntity<List<PolicyResponse>> getAllPoliciesByProductId(@PathVariable Long id) {
        return status(HttpStatus.OK).body(policyService.getAllPoliciesByProductId(id));
    }
}