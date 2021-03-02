package com.example.springredditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyResponse {
    private Long id;
    private String policyName;
    private String policyDescription;
    //private Instant policyCreatedDate;

    private String productName;
}
