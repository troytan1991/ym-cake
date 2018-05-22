package com.troytan.ymcake.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troytan.ymcake.domain.User;
import com.troytan.ymcake.dto.OauthDto;
import com.troytan.ymcake.repository.UserMapper;
import com.troytan.ymcake.util.SHAUtils;
import com.troytan.ymcake.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

    private ThreadLocal<Long> userHolder = new ThreadLocal<>();
    private Map<String, Long> map        = new HashMap<>();
    @Autowired
    private UserMapper        userMapper;

    @Override
    public void setCurrentUser(Long userId) {
        userHolder.set(userId);

    }

    @Override
    public Long getCurrentUser() {
        // return userHolder.get();
        return userHolder.get();
    }

    /**
     * 记录用户，并且返回自定义登录态
     *
     * @author troytan
     * @date 2018年5月17日
     * @param oauthDto
     * @param userVo
     * @return
     * @throws NoSuchAlgorithmException (non-Javadoc)
     * @see com.troytan.ymcake.service.UserService#logUser(com.troytan.ymcake.dto.OauthDto,
     * com.troytan.ymcake.vo.UserVo)
     */
    @Override
    public String logUser(OauthDto oauthDto, UserVo userVo) throws NoSuchAlgorithmException {
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
        String shaKey = SHAUtils.getSha1(oauthDto.getOpenid() + oauthDto.getSession_key());

        // 移除当前用户session数据
        Iterator<Entry<String, Long>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, Long> entry = iterator.next();
            if (entry.getValue().equals(user.getUserId())) {
                map.remove(entry.getKey());
            }
        }

        // 重新存入用户信息到缓存中
        map.put(shaKey, user.getUserId());
        return shaKey;
    }

    @Override
    public Long checkSessionId(String sessionId) {

        return map.get(sessionId);
    }

}
