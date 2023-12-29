package com.techbazaar.backend.Repository;

import com.techbazaar.backend.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order,Long> {
}
