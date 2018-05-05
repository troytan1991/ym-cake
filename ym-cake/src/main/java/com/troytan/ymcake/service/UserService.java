package com.troytan.ymcake.service;

public interface UserService {

    void setCurrentUser(Long userId);

    Long getCurrentUser();
}
