package com.berkin.example.services.impl;


import com.berkin.example.entity.UserEntity;
import com.berkin.example.repository.UserRepository;
import com.berkin.example.services.UserService;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(Jdbi jdbi) {
        this.repository = jdbi.onDemand(UserRepository.class);
    }

    @Override
    public UserEntity create(UserEntity user) {

        // random password
        String dummyPassword = generateRandomPassword();
        user.setPassword(dummyPassword);

        long userId = repository.insert(user); // Insert user
        user.setId(userId);

        repository.insertUserBalance(user); // Insert user balance

        return getOne(userId);
    }

    @Override
    public List<UserEntity> getAll(){
        return repository.findAll();
    }

    @Override
    public UserEntity getOne(long id) {
        UserEntity user = repository.findById(id);
        if(ObjectUtils.isEmpty(user)){
            try {
                throw new Exception(MessageFormat.format("User id {0} not found", String.valueOf(id)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return user;
    }

    @Override
    public int deleteById(long id) {
        return repository.deleteById(id);
    }

    private String generateRandomPassword() {
        // generate random password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    @Override
    public UserEntity setPassword(UserEntity user, String password) {
        // set password to new user
        user.setPassword(password);

        // update entity
        repository.update(user);

        return user;
    }

    @Override
    public UserEntity getUserInfo(long id) {
        UserEntity user = getOne(id);

        return user; // to be continued...
    }


}