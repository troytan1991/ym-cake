package com.troytan.ymcake.dto;

import java.util.Date;
import java.util.List;

import com.troytan.ymcake.domain.ProductOrder;

public class OrderDto {

    private List<ProductOrder> productList;
    private Long               addrId;
    private Short              type;
    private Date               receiveTime;

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

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

}
