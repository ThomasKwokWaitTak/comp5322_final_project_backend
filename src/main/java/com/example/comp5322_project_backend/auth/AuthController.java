package com.example.comp5322_project_backend.auth;

import com.example.comp5322_project_backend.auth.entities.UserAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("sign-up")
    public void register(UserAccount userInfo) {
        this.authService.createUser(userInfo);
    }
}