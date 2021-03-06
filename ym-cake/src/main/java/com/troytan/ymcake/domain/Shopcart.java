package com.troytan.ymcake.domain;

import java.util.Date;

public class Shopcart {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_shopcart.SHOPCART_ID
     *
     * @mbg.generated
     */
    private Long shopcartId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_shopcart.USER_ID
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_shopcart.PRODUCT_ID
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_shopcart.count
     *
     * @mbg.generated
     */
    private Short count;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_shopcart.created_on
     *
     * @mbg.generated
     */
    private Date createdOn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_shopcart.created_by
     *
     * @mbg.generated
     */
    private String createdBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_shopcart.updated_on
     *
     * @mbg.generated
     */
    private Date updatedOn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_shopcart.updated_by
     *
     * @mbg.generated
     */
    private String updatedBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_shopcart.SIZE_ID
     *
     * @mbg.generated
     */
    private Long sizeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_shopcart.SHOPCART_ID
     *
     * @return the value of tt_shopcart.SHOPCART_ID
     *
     * @mbg.generated
     */
    public Long getShopcartId() {
        return shopcartId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_shopcart.SHOPCART_ID
     *
     * @param shopcartId the value for tt_shopcart.SHOPCART_ID
     *
     * @mbg.generated
     */
    public void setShopcartId(Long shopcartId) {
        this.shopcartId = shopcartId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_shopcart.USER_ID
     *
     * @return the value of tt_shopcart.USER_ID
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_shopcart.USER_ID
     *
     * @param userId the value for tt_shopcart.USER_ID
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_shopcart.PRODUCT_ID
     *
     * @return the value of tt_shopcart.PRODUCT_ID
     *
     * @mbg.generated
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_shopcart.PRODUCT_ID
     *
     * @param productId the value for tt_shopcart.PRODUCT_ID
     *
     * @mbg.generated
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_shopcart.count
     *
     * @return the value of tt_shopcart.count
     *
     * @mbg.generated
     */
    public Short getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_shopcart.count
     *
     * @param count the value for tt_shopcart.count
     *
     * @mbg.generated
     */
    public void setCount(Short count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_shopcart.created_on
     *
     * @return the value of tt_shopcart.created_on
     *
     * @mbg.generated
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_shopcart.created_on
     *
     * @param createdOn the value for tt_shopcart.created_on
     *
     * @mbg.generated
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_shopcart.created_by
     *
     * @return the value of tt_shopcart.created_by
     *
     * @mbg.generated
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_shopcart.created_by
     *
     * @param createdBy the value for tt_shopcart.created_by
     *
     * @mbg.generated
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_shopcart.updated_on
     *
     * @return the value of tt_shopcart.updated_on
     *
     * @mbg.generated
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_shopcart.updated_on
     *
     * @param updatedOn the value for tt_shopcart.updated_on
     *
     * @mbg.generated
     */
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_shopcart.updated_by
     *
     * @return the value of tt_shopcart.updated_by
     *
     * @mbg.generated
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_shopcart.updated_by
     *
     * @param updatedBy the value for tt_shopcart.updated_by
     *
     * @mbg.generated
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_shopcart.SIZE_ID
     *
     * @return the value of tt_shopcart.SIZE_ID
     *
     * @mbg.generated
     */
    public Long getSizeId() {
        return sizeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_shopcart.SIZE_ID
     *
     * @param sizeId the value for tt_shopcart.SIZE_ID
     *
     * @mbg.generated
     */
    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }
}