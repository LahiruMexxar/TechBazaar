package com.techbazaar.backend.Repository;

import com.techbazaar.backend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long> {
}
