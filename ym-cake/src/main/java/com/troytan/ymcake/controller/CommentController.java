package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.Page;
import com.troytan.ymcake.aspect.NoAuth;
import com.troytan.ymcake.dto.CommentDto;
import com.troytan.ymcake.service.CommentService;
import com.troytan.ymcake.vo.CommentVo;

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
    public List<CommentVo> getComments(@PathParam("productId") Long productId,
                                       @DefaultValue("1") @QueryParam("pageNum") Integer pageNum,
                                       @DefaultValue("10") @QueryParam("pageSize") Integer pageSize) {

        return commentService.getCommentList(productId, new Page<>(pageNum, pageSize));
    }

    @PUT
    @Path("/{orderId}")
    public void commentOrder(List<CommentDto> comments, @PathParam("orderId") Long orderId) {
        commentService.commentOrder(orderId, comments);
    }

}
