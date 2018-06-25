package com.troytan.ymcake.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ClientErrorException;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.troytan.ymcake.service.UserService;

@Component
@Aspect
public class AuthAspect {

    @Autowired
    private UserService        userService;
    @Autowired
    private HttpServletRequest request;

    @Before("within(com.troytan.ymcake.controller..*) && !@annotation(com.troytan.ymcake.aspect.NoAuth)")
    public void checkRequest() {
        // 生产用
//        String sessionId = request.getParameter("sessionId");
//        Long userId = userService.checkSessionId(sessionId);
//        if (userId == null) {
//            throw new ClientErrorException(401);
//        }
//        userService.setCurrentUser(userId);

        // 测试用
         userService.setCurrentUser(1L);
    }
}
