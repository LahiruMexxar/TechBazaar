package com.techbazaar.backend.Repository;

import com.techbazaar.backend.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    boolean existsByName(String name);
}
