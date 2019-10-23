package com.ua.dao;

import com.ua.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String userName);

    User findUserByEmail(String email);

    User findUserByActivationCode(String code);
}
