package com.example.springredditclone.controller;

import com.example.springredditclone.dto.PolicyRequest;
import com.example.springredditclone.service.PolicyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies/")
@AllArgsConstructor
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping
    public ResponseEntity<Void> createPolicy(@RequestBody PolicyRequest policyRequest) {
        policyService.save(policyRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<PostResponse>> getAllPosts() {
//        return status(HttpStatus.OK).body(postService.getAllPosts());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
//        return status(HttpStatus.OK).body(postService.getPost(id));
//    }
//
//    @GetMapping("/by-subreddit/{id}")
//    public ResponseEntity<List<PostResponse>> getPostsBySubreddit(@PathVariable Long id) {
//        return status(HttpStatus.OK).body(postService.getPostsBySubreddit(id));
//    }
//
//    @GetMapping("/by-user/{userName}")
//    public ResponseEntity<List<PostResponse>> getPostsByUsername(@PathVariable String userName){
//        return ResponseEntity.status(OK)
//                .body(postService.getPostsByUsername(userName));
//    }
}