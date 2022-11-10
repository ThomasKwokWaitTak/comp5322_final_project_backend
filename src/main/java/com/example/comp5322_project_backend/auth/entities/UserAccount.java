package com.example.comp5322_project_backend.auth.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userAccount")
@Setter @Getter @EqualsAndHashCode @NoArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(unique = true, nullable = false)
    @Size(min = 4, message = "Username is too short")
    @Size(max = 35, message = "Username is too long")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Column(nullable = false)
    @Size(min = 8, message = "Password is too short")
    @Size(max = 50, message = "Password is too long")
    @NotBlank(message = "Password cannot be blank")
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
