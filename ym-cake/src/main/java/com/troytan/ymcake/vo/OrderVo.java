package com.troytan.ymcake.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderVo {

    private Long                 orderId;
    private Short                status;
    private BigDecimal           price;
    private Date                 createdOn;
    private Date                 updatedOn;
    private Long                 deliveryId;
    private List<OrderProductVo> productList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public List<OrderProductVo> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderProductVo> productList) {
        this.productList = productList;
    }

}
