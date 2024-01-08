package com.techbazaar.backend.Repository;

import com.techbazaar.backend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);

}
