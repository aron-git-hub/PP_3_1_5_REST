package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private final UserDao userDao;
    public UserDetailsServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found" ));
    }
}