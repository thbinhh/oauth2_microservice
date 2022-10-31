package com.example.oauthserver.service;

import com.example.oauthserver.entities.CustomUserDetail;
import com.example.oauthserver.entities.User;
import com.example.oauthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);

        if(user == null)
        {
            throw new UsernameNotFoundException(username+" not found");
        }
        return new CustomUserDetail(user);
    }
}
