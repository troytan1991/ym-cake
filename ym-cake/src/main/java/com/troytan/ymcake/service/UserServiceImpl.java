package com.troytan.ymcake.service;

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
