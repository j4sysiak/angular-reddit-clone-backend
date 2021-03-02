package com.example.springredditclone.service;

import com.example.springredditclone.dto.PolicyRequest;
import com.example.springredditclone.exceptions.ProductNotFoundException;
import com.example.springredditclone.exceptions.SubredditNotFoundException;
import com.example.springredditclone.mapper.PolicyMapper;
import com.example.springredditclone.mapper.PostMapper;
import com.example.springredditclone.model.*;
import com.example.springredditclone.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PolicyService {

    private final ProductRepository productRepository;
    private final PolicyRepository policyRepository;
    private final PolicyMapper policyMapper;

    public Policy save(PolicyRequest policyRequest) {

        Product product = productRepository.findByName(policyRequest.getProductName()).orElseThrow(() ->
                new ProductNotFoundException(policyRequest.getProductName()));

        User tmpUser = new User(1L,"user1", "user1", "user1@wp.pl");
        //User tmpUser = authService.getCurrentUser();

        return policyRepository.save(policyMapper.map(policyRequest, product));
    }
}
