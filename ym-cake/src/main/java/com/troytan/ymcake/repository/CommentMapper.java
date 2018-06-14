package com.troytan.ymcake.repository;

import java.util.List;

import com.troytan.ymcake.domain.Comment;
import com.troytan.ymcake.dto.CommentDto;
import com.troytan.ymcake.vo.CommentVo;

public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_comment
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_comment
     *
     * @mbg.generated
     */
    int insert(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_comment
     *
     * @mbg.generated
     */
    Comment selectByPrimaryKey(Long commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_comment
     *
     * @mbg.generated
     */
    List<Comment> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_comment
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Comment record);

    List<CommentVo> listByProductId(Long productId);
}