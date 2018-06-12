package com.troytan.ymcake.service;

import java.util.List;

import com.troytan.ymcake.dto.CommentDto;

public interface CommentService {

    List<CommentDto> getCommentList(Long productId);
    void commentOrder(Long orderId, List<CommentDto> comments);
}
