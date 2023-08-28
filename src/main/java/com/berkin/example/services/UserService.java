package com.berkin.example.services;

import com.berkin.example.entity.UserEntity;


import java.util.List;

public interface UserService {

    UserEntity create(UserEntity user);

    List<UserEntity> getAll();

    UserEntity getOne(long id);

    int deleteById(long id);
    UserEntity setPassword(UserEntity user, String password);

    UserEntity getUserInfo(long id);

}
