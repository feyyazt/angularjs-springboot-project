package com.todo.service.impl;

import com.todo.entity.User;
import com.todo.repository.UserRepository;
import com.todo.advice.UsernameNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findByUsername(username);
        if(user.isPresent()){
            return new UserDetailsImpl(user.get());
        }else{
            log.error("kullanıcı bulunamadı");
           throw new UsernameNotFoundException("Kullanıcı Bulunamadı");
        }
    }
}
