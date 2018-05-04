package com.troytan.ymcake.dto;

public class SendMsg {

    private String      toser;
    private String      msgtype;
    private SendMsgText text;

    public String getToser() {
        return toser;
    }

    public void setToser(String toser) {
        this.toser = toser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public SendMsgText getText() {
        return text;
    }

    public void setText(SendMsgText text) {
        this.text = text;
    }

}
