package com.troytan.ymcake.dto;

import java.util.Date;
import java.util.List;

import com.troytan.ymcake.domain.ProductOrder;

public class OrderDto {

    private List<ProductOrder> productList;
    private Long               addrId;
    private Short              deliverMethod; // 配送方式:0专人配送,1门店自提
    private Short              payMethod;     // 支付方式:0在线支付,1货到付款
    private Date               deliverDate;   // 配送日期
    private String             deliverTime;   // 配送时间
    private String             remark;        // 备注

    public List<ProductOrder> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductOrder> productList) {
        this.productList = productList;
    }

    public Long getAddrId() {
        return addrId;
    }

    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    public Short getDeliverMethod() {
        return deliverMethod;
    }

    public void setDeliverMethod(Short deliverMethod) {
        this.deliverMethod = deliverMethod;
    }

    public Short getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Short payMethod) {
        this.payMethod = payMethod;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
