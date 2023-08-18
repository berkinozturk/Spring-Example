package com.berkin.example.entity;

import jakarta.persistence.*;

import java.io.Serializable;

import lombok.Data;
@Entity
@Table(name = "users")
@Data
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
}
