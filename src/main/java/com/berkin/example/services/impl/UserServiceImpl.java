package com.berkin.example.services.impl;


import com.berkin.example.entity.UserEntity;
import com.berkin.example.repository.UserRepository;
import com.berkin.example.services.UserService;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(Jdbi jdbi) {
        this.repository = jdbi.onDemand(UserRepository.class);
    }

    @Override
    public UserEntity create(UserEntity user) {
        return getOne(repository.insert(user));
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

}