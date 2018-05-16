package com.troytan.ymcake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troytan.ymcake.domain.User;
import com.troytan.ymcake.dto.OauthDto;
import com.troytan.ymcake.repository.UserMapper;
import com.troytan.ymcake.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

    private static ThreadLocal<Long> userHolder = new ThreadLocal<>();

    @Autowired
    private UserMapper               userMapper;

    @Override
    public void setCurrentUser(Long userId) {
        userHolder.set(userId);

    }

    @Override
    public Long getCurrentUser() {
        // return userHolder.get();
        return 1L;
    }

    @Override
    public String logUser(OauthDto oauthDto, UserVo userVo) {
        User user = userMapper.selectByOpenId(oauthDto.getOpenid());
        if (user == null) {
            // 插入user表
            user = new User();
            user.setAvatarUrl(userVo.getAvatarUrl());
            user.setGender(userVo.getGender());
            user.setNickname(userVo.getNickName());
            user.setOpenId(oauthDto.getOpenid());
            user.setProvince(userVo.getProvince());

            userMapper.insert(user);
        }
        // 存入用户信息到缓存中
        
        return null;
    }

}
