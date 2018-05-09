package com.troytan.ymcake.vo;

import java.util.List;

import com.troytan.ymcake.domain.ProductPic;
import com.troytan.ymcake.domain.Size;

public class ProductVo {

    private Long             productId;
    private String           imgUrl;
    private String           title;
    private String           description;
    private String           detailUrl;
    private List<ProductPic> productPicList;
    private List<Size>       sizeList;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public List<Size> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<Size> sizeList) {
        this.sizeList = sizeList;
    }

    public List<ProductPic> getProductPicList() {
        return productPicList;
    }

    public void setProductPicList(List<ProductPic> productPicList) {
        this.productPicList = productPicList;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
