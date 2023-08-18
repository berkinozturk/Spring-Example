package com.berkin.example.entity;

import jakarta.persistence.*;

import java.io.Serializable;

import lombok.Data;
@Entity
@Table(name = "users")
@Data
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String userName;

    @Column
    private String firstName;

    @Column
    private String lastName;
}
