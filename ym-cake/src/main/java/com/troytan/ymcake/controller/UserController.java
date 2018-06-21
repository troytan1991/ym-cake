package com.troytan.ymcake.controller;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.troytan.ymcake.aspect.NoAuth;
import com.troytan.ymcake.dto.OauthDto;
import com.troytan.ymcake.manager.WechatManager;
import com.troytan.ymcake.service.UserService;
import com.troytan.ymcake.vo.UserVo;

@Controller
@Path("/user")
@Consumes("application/json;charset=utf-8")
@Produces({ "application/json;charset=utf-8", MediaType.TEXT_PLAIN })
public class UserController {

    @Autowired
    private WechatManager wechatManager;
    @Autowired
    private UserService   userService;

    @PUT
    @Path("/login")
    @NoAuth
    public String getSessionId(UserVo userVo) throws NoSuchAlgorithmException {
        OauthDto oauthDto = wechatManager.requestOauth(userVo.getCode());

        return userService.logUser(oauthDto, userVo);
    }

    @GET
    @Path("/role")
    public Short getUserRole() {
        return userService.getUserRole();
    }
}
