package com.troytan.ymcake.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;

import com.troytan.ymcake.vo.ReceiveMsg;

@Controller
@Path("/contact")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class ContactController {

    @Path("/receiveMsg")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String receiveMsg(ReceiveMsg receiveMsg) {
        
        return "success";
    }

}
