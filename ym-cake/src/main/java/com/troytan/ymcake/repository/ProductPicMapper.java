package com.troytan.ymcake.repository;

import com.troytan.ymcake.domain.ProductPic;
import java.util.List;

public interface ProductPicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_product_pic
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long productPicId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_product_pic
     *
     * @mbg.generated
     */
    int insert(ProductPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_product_pic
     *
     * @mbg.generated
     */
    ProductPic selectByPrimaryKey(Long productPicId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_product_pic
     *
     * @mbg.generated
     */
    List<ProductPic> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_product_pic
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ProductPic record);
}