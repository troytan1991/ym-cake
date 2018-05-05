package com.troytan.ymcake.domain;

public class DomainConst {

    // tt_order
    public static final Short STATUS_NEW      = 1;  // 新建
    public static final Short STATUS_PAY      = 10; // 已支付
    public static final Short STATUS_DELIVER  = 50; // 已发货
    public static final Short STATUS_RECEIVE  = 90; // 已签收
    public static final Short STATUS_COMPLETE = 100;// 已完成
    public static final Short STATUS_CANCEL   = 0;  // 取消
}
