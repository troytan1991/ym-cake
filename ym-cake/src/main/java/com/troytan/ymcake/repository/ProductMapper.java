package com.troytan.ymcake.repository;

import com.troytan.ymcake.domain.Product;
import com.troytan.ymcake.vo.ProductVo;

import java.util.List;

public interface ProductMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_product
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_product
     *
     * @mbg.generated
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_product
     *
     * @mbg.generated
     */
    Product selectByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_product
     *
     * @mbg.generated
     */
    List<Product> selectAll();

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Product record);

    ProductVo selectVoByPrimaryKey(Long productId);
}
