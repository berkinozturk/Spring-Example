package com.berkin.example.entity;


import lombok.Data;

import java.io.Serializable;


@Data
public class UserEntity implements Serializable {



    private Long id;


    private String username;


    private String firstname;


    private String lastname;
}
