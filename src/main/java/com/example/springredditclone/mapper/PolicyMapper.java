package com.example.springredditclone.mapper;

import com.example.springredditclone.dto.PolicyRequest;
import com.example.springredditclone.dto.PolicyResponse;
import com.example.springredditclone.dto.ProductDto;
import com.example.springredditclone.dto.SubredditDto;
import com.example.springredditclone.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PolicyMapper {

    @Mapping(target = "productName", source = "product.name")
    public abstract PolicyRequest mapPolicyToDto(Policy policy);

    @Mapping(target = "policyName", source = "policyRequest.policyName")
    @Mapping(target = "policyDescription", source = "policyRequest.policyDescription")
    @Mapping(target = "policyCreatedDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "product", source = "product")
    public abstract Policy map(PolicyRequest policyRequest, Product product);

    @Mapping(target = "id", source = "policyId")
    @Mapping(target = "productName", source = "product.name")
    public abstract PolicyResponse mapToDto(Policy policy);





}
