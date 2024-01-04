package com.techbazaar.backend.Services;

import com.techbazaar.backend.DTO.UserRegistrationDTO;
import com.techbazaar.backend.Models.User;
import com.techbazaar.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User register(UserRegistrationDTO registrationDTO) {
        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setEmail(registrationDTO.getEmail());
        user.setRoles(Collections.singleton("ROLE_USER"));
        user.setEnabled(false); // User is not enabled until email verification
        userRepository.save(user);
        return user;
    }

    @Override
    public void verifyAccount(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);

        if (user == null) {
            throw new RuntimeException("Invalid verification code");
        }

        user.setEnabled(true);
        user.setVerificationCode(null);

        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void updateProfile(User user) {

    }


    @Override
    public void initiatePasswordReset(String email) {

    }

    @Override
    public void completePasswordReset(String token, String newPassword) {

    }
}
