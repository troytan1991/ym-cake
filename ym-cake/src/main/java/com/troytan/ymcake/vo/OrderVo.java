package com.troytan.ymcake.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.troytan.ymcake.domain.DomainConst;

public class OrderVo {

    private Long                 orderId;
    private Short                status;
    private String               statusStr;
    private Date                 createdOn;
    private Short                payMethod;
    private Short                deliverMethod;
    private String                deliveryNo;
    private String               location;
    private String               receiver;
    private String               remark;
    private BigDecimal           price;
    private BigDecimal           deliveryFee;
    private List<OrderProductVo> productList;

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

    public Short getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Short payMethod) {
        this.payMethod = payMethod;
    }

    public Short getDeliverMethod() {
        return deliverMethod;
    }

    public void setDeliverMethod(Short deliverMethod) {
        this.deliverMethod = deliverMethod;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

}
