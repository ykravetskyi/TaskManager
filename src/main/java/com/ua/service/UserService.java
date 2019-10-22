package com.ua.service;

import com.ua.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);

    User findUserByUsername(String username);

    List<User> findAll();

    boolean activation(String code);
}
