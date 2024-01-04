package com.techbazaar.backend.Services;

import com.techbazaar.backend.DTO.UserRegistrationDTO;
import com.techbazaar.backend.Models.User;

public interface UserService {
    User register(UserRegistrationDTO registrationDTO);
    void verifyAccount(String verificationCode);
    User findByUsername(String username);
    User findByEmail(String email);
    void updateProfile(User user);
    void initiatePasswordReset(String email);
    void completePasswordReset(String token, String newPassword);
}
