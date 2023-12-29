package com.techbazaar.backend.Controllers;

import com.techbazaar.backend.DTO.ApiResponse;
import com.techbazaar.backend.Models.Product;
import com.techbazaar.backend.Repository.ProductRepository;
import com.techbazaar.backend.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(new ApiResponse<>(200, "Products retrieved", products));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(500, "An error occurred while retrieving the products", new ArrayList<>()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<List<Product>>> createProduct(@RequestBody Product product) {
        try {
            //List<Product> products = productService.addNewProducts(product);
            return ResponseEntity.ok(new ApiResponse<>(200, "Products retrieved", products));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(500, "An error occurred while retrieving the products", new ArrayList<>()));
        }
    }
}
