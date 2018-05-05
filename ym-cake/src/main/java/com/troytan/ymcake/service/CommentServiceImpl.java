package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troytan.ymcake.domain.Comment;
import com.troytan.ymcake.domain.DomainConst;
import com.troytan.ymcake.dto.CommentDto;
import com.troytan.ymcake.repository.CommentMapper;
import com.troytan.ymcake.repository.OrderMapper;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserService   userService;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private OrderMapper   orderMapper;

    @Override
    public List<Comment> getCommentList(Long productId) {
        return commentMapper.selectByProductId(productId);
    }

    /**
     * 评价订单
     *
     * @author troytan
     * @date 2018年5月5日
     * @param orderId
     * @param content
     * @return (non-Javadoc)
     * @see com.troytan.ymcake.service.OrderService#commentOrder(java.lang.Long, java.lang.String)
     */
    @Override
    public Comment createComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setOrderId(commentDto.getOrderId());
        comment.setUserId(userService.getCurrentUser());
        comment.setCreatedBy("admin");
        commentMapper.insert(comment);

        orderMapper.updateStatusById(commentDto.getOrderId(), DomainConst.STATUS_COMPLETE);
        return comment;
    }
}