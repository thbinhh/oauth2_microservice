package com.example.UserService.service;

import com.example.UserService.entities.User;
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

    public void login();
}
