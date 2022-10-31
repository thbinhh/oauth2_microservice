package com.example.UserService.service.Impl;

import com.example.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {
    @Autowired
    UserRepository userRepo;

    public boolean hasUserId(Authentication authentication, Integer userId) {

        int userID = userRepo.findByUserName(authentication.getName()).getUserId();
        System.out.println(authentication.getName());
        System.out.println(userID);
//		System.out.println(userId+"  "+userID);
        if (userID == userId)
            return true;

        return false;
    }
}
