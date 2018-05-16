package com.troytan.ymcake.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.troytan.ymcake.domain.DomainConst;

public class OrderVo {

    private Long                 orderId;
    private Date                 createdOn;
    private Short                status;
    private String               statusStr;
    private List<OrderProductVo> productList;
    private BigDecimal           price;
    private Long                 deliveryId;
    private BigDecimal           deliveryFee;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<OrderProductVo> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderProductVo> productList) {
        this.productList = productList;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public void mapToStatusStr() {
        if (status == DomainConst.STATUS_NEW) {
            statusStr = "待付款";
        } else if (status == DomainConst.STATUS_PAY) {
            statusStr = "待发货";
        } else if (status == DomainConst.STATUS_DELIVER) {
            statusStr = "待收货";
        } else if (status == DomainConst.STATUS_RECEIVE) {
            statusStr = "待评价";
        } else if (status == DomainConst.STATUS_COMPLETE) {
            statusStr = "已完成";
        } else if (status == DomainConst.STATUS_CANCEL) {
            statusStr = "已取消";
        }

    }

}
