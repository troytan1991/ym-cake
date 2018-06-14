package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.ymcake.domain.Comment;
import com.troytan.ymcake.domain.DomainConst;
import com.troytan.ymcake.dto.CommentDto;
import com.troytan.ymcake.repository.CommentMapper;
import com.troytan.ymcake.repository.OrderMapper;
import com.troytan.ymcake.vo.CommentVo;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserService   userService;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private OrderMapper   orderMapper;

    @Override
    public void commentOrder(Long orderId, List<CommentDto> comments) {
        // 插入tt_comment
        for (CommentDto commentDto : comments) {
            Comment comment = new Comment();
            comment.setComment(commentDto.getText());
            comment.setOrderId(orderId);
            comment.setProductId(commentDto.getProductId());
            comment.setUserId(userService.getCurrentUser());
            comment.setRate(commentDto.getRate());
            comment.setCreatedBy(userService.getCurrentUser().toString());
            commentMapper.insert(comment);
        }
        // 更新订单状态
        orderMapper.updateStatusById(orderId, DomainConst.STATUS_COMPLETE);
    }

    @Override
    public List<CommentVo> getCommentList(Long productId) {

        return commentMapper.listByProductId(productId);
    }

}
