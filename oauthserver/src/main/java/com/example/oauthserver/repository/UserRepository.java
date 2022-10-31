package com.example.oauthserver.repository;

import com.example.oauthserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
    Boolean existsByUserId(String id);
}
