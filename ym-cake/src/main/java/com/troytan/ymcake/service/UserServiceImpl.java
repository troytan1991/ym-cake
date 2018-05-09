package com.troytan.ymcake.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static ThreadLocal<Long> userHolder = new ThreadLocal<>();

    @Override
    public void setCurrentUser(Long userId) {
        userHolder.set(userId);

    }

    @Override
    public Long getCurrentUser() {
        // return userHolder.get();
        return 1L;
    }

}
