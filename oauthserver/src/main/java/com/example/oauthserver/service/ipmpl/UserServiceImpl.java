package com.example.oauthserver.service.ipmpl;

import com.example.oauthserver.entities.User;
import com.example.oauthserver.repository.UserRepository;
import com.example.oauthserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    Logger log= LoggerFactory.getLogger(UserService.class);

    @Override
    public void save(User user) {
        log.info("saving user");
        userRepository.save(user);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
    public Optional<User> update(int userId, User user) {
        return userRepository.findById(userId);
    }

    @Override
    public void delete(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
