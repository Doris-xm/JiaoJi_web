package com.example.jiaoji_app_back.daoimpl;

import com.example.jiaoji_app_back.dao.UserDao;
import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.entity.UserAuth;
import com.example.jiaoji_app_back.repository.UserAuthRepository;
import com.example.jiaoji_app_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserAuth checkUser(String username, String password){
        return userAuthRepository.checkUser(username,password);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        return userRepository.findByUserId(userId);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean isAdmin(Integer userId) {
        UserAuth userAuth = userAuthRepository.findUserAuthByUserId(userId);
        return userAuth.getUserType() == 1;
    }
    @Override
    public User getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public boolean createNewUser(User user) {
        userRepository.save(user);
        return true;
    }
    @Override
    public boolean createNewUserAuth(UserAuth userAuth) {
        userAuthRepository.save(userAuth);
        return true;
    }
}
