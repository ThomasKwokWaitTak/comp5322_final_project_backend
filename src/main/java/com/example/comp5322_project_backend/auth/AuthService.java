package com.example.comp5322_project_backend.auth;

import com.example.comp5322_project_backend.auth.entities.UserAccount;
import com.example.comp5322_project_backend.auth.repositories.UserAccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
    private final UserAccountRepository userRepository;

    public AuthService(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserAccount userInfo) {
       if (userRepository.findByUsername(userInfo.getUsername()).isPresent()) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
       }
       userRepository.save(userInfo);
   }
}