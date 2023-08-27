package com.berkin.example.controller;

import com.berkin.example.entity.UserEntity;
import com.berkin.example.repository.UserRepository;
import com.berkin.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getAll();
    }


}
