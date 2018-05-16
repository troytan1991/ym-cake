package com.troytan.ymcake.manager;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.troytan.ymcake.dto.OauthDto;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WechatManagerTest {

    @Autowired
    private WechatManager wechatManager;

    @Test
    public void oauthTest() throws JsonParseException, JsonMappingException, IOException {
        OauthDto oauthDto = wechatManager.requestOauth("071DVJ461iKGcM1MoZ461CzO461DVJ4A");
        System.out.println(oauthDto.getOpenid());
    }

}
