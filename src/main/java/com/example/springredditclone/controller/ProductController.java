package com.example.springredditclone.controller;

import com.example.springredditclone.dto.ProductDto;
import com.example.springredditclone.dto.SubredditDto;
import com.example.springredditclone.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.save(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProduct(id));
    }
}
