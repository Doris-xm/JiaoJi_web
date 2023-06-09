package com.example.jiaoji_app_back.repository;

import com.example.jiaoji_app_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserId(Integer userId);
    List<User> findAll();
    User findByUsername(String username);
}
