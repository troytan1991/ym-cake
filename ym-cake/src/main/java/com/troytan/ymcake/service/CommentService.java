package com.troytan.ymcake.service;

import java.util.List;

import com.troytan.ymcake.domain.Comment;
import com.troytan.ymcake.dto.CommentDto;
import com.troytan.ymcake.vo.CommentVo;

public interface CommentService {

    List<CommentVo> getCommentList(Long productId);

    Comment createComment(CommentDto commentDto);

}
