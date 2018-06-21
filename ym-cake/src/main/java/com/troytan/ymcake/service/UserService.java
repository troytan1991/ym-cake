package com.troytan.ymcake.service;

import java.security.NoSuchAlgorithmException;

import com.troytan.ymcake.dto.OauthDto;
import com.troytan.ymcake.vo.UserVo;

public interface UserService {

    void setCurrentUser(Long userId);

    Long getCurrentUser();

    String logUser(OauthDto oauthDto, UserVo userVo) throws NoSuchAlgorithmException;

    Long checkSessionId(String sessionId);

    Short getUserRole();
}
