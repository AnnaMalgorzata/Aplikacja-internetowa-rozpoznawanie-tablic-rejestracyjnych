package org.example.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    private int age;
    private String email;
    private String username;
    private String password;
    @Column(name = "IS_ADMIN")
    private boolean isAdmin;
}
