package com.vic.springsecuritymongodb.SecurityConfig;

import com.vic.springsecuritymongodb.Model.MyUserDetails;
import com.vic.springsecuritymongodb.Model.User;
import com.vic.springsecuritymongodb.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepo.findUsersByName(s).orElseThrow(() ->new UsernameNotFoundException("Not found "+s));
        return new MyUserDetails(user);
    }
}
