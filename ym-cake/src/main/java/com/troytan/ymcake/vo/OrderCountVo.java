package com.troytan.ymcake.vo;

public class OrderCountVo {

    private Short statusNew;      // 待支付
    private Short statusPay;      // 待发货
    private Short statusDelivery; // 待收货
    private Short statusReceive;  // 待评价

    public Short getStatusNew() {
        return statusNew;
    }

    public void setStatusNew(Short statusNew) {
        this.statusNew = statusNew;
    }

    public Short getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(Short statusPay) {
        this.statusPay = statusPay;
    }

    public Short getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(Short statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public Short getStatusReceive() {
        return statusReceive;
    }

    public void setStatusReceive(Short statusReceive) {
        this.statusReceive = statusReceive;
    }

}
