package com.troytan.ymcake.vo;

import java.math.BigDecimal;

public class ShopcartVo {

    private Long       shopcartId;
    private Short      count;
    private Long       productId;
    private String     imgUrl;
    private String     title;
    private Long       sizeId;
    private String     description;
    private BigDecimal price;
    private Boolean    isSelected;

    public Long getShopcartId() {
        return shopcartId;
    }

    public void setShopcartId(Long shopcartId) {
        this.shopcartId = shopcartId;
    }

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

}
