package com.appcourse.security.jwt;


import com.appcourse.entity.User;
import com.appcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        return username.contains("@") ?
                userRepository.findByUsername(username).orElseThrow(
                        () -> new UsernameNotFoundException("User not found with - " + username)) :
                userRepository.findByUsername(username.toLowerCase(Locale.ROOT)).orElseThrow(
                        () -> new UsernameNotFoundException("User not found with - " + username)
                );
    }
}
