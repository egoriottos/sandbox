package com.example.authandauthz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Usernames", unique = true, nullable = false)
    private String username;
    @Column(name = "Passwords", nullable = false)
    private String password;
    @Column(name = "Roles")
    private String role;
}
