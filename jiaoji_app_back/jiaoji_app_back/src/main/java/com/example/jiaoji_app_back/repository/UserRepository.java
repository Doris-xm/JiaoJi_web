package com.example.jiaoji_app_back.repository;

import com.example.jiaoji_app_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
