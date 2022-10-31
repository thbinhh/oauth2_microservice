package com.example.oauthserver.service;

import com.example.oauthserver.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public void save(User user);

    public Optional<User> update(int userId, User user);

    public void delete(int userId);

    public List<User> getUsers();

    public Optional<User> getUserById(int userId);

    public User getUserByUserName(String userName);
}
