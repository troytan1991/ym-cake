package com.troytan.ymcake.service;

import java.util.List;

import com.troytan.ymcake.domain.Comment;
import com.troytan.ymcake.dto.CommentDto;

public interface CommentService {

    List<Comment> getCommentList(Long productId);

    Comment createComment(CommentDto commentDto);

}
