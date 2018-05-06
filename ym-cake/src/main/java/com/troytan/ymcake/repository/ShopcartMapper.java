package com.troytan.ymcake.repository;

import com.troytan.ymcake.domain.ProductOrder;
import com.troytan.ymcake.domain.Shopcart;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ShopcartMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long shopcartId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    int insert(Shopcart record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    Shopcart selectByPrimaryKey(Long shopcartId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    List<Shopcart> selectAll();

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Shopcart record);

    void updateCountByOrder(@Param("order") ProductOrder productOrder, @Param("userId") Long currentUser);
}