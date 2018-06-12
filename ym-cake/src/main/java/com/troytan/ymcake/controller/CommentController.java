package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.troytan.ymcake.aspect.NoAuth;
import com.troytan.ymcake.dto.CommentDto;
import com.troytan.ymcake.service.CommentService;

@Controller
@Path("/comment")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GET
    @Path("/{productId}")
    @NoAuth
    public List<CommentDto> getComments(@PathParam("productId") Long productId) {
        return commentService.getCommentList(productId);
    }

    @PUT
    @Path("/{orderId}")
    public void commentOrder(List<CommentDto> comments, @PathParam("orderId") Long orderId) {
        commentService.commentOrder(orderId, comments);
    }

}
