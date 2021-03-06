package com.troytan.ymcake.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.troytan.ymcake.domain.ProductOrder;
import com.troytan.ymcake.domain.Shopcart;
import com.troytan.ymcake.vo.ShopcartVo;

public interface ShopcartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long shopcartId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    int insert(Shopcart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    Shopcart selectByPrimaryKey(Long shopcartId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    List<Shopcart> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_shopcart
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Shopcart record);

    void updateCountByOrder(@Param("order") ProductOrder productOrder, @Param("userId") Long userId);

    Shopcart selectByProductAndUser(@Param("productId") Long productId, @Param("sizeId") Long sizeId,
                                    @Param("userId") Long userId);

    int selectCountByUser(Long userId);

    void addCountByProduct(@Param("productId") Long productId, @Param("sizeId") Long sizeId,
                           @Param("userId") Long userId);

    void subCountByProduct(@Param("productId") Long productId, @Param("sizeId") Long sizeId,
                           @Param("userId") Long userId);

    void deleteByProduct(@Param("productId") Long productId, @Param("sizeId") Long sizeId,
                              @Param("userId") Long userId);

    List<ShopcartVo> selectByUser(Long userId);

    void deleteByKeyAndUser(@Param("shopcartId") Long shopcartId,@Param("userId") Long userId);

}