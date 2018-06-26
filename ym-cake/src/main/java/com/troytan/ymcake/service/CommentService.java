package com.troytan.ymcake.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.troytan.ymcake.dto.CommentDto;
import com.troytan.ymcake.vo.CommentVo;

public interface CommentService {

    List<CommentVo> getCommentList(Long productId, Page<?> page);
    void commentOrder(Long orderId, List<CommentDto> comments);
}
