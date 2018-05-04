package com.troytan.ymcake.vo;

import java.util.Date;

/**
 * "ToUserName": "toUser", "FromUserName": "fromUser", "CreateTime": 1482048670, "MsgType": "text", "Content": "this is
 * a test", "MsgId": 1234567890123456
 * 
 * @author troytan
 * @date 2018年5月1日
 */
public class ReceiveMsg {

    private String toUserName;
    private String fromUserName;
    private Date   createTime;
    private String msgType;
    private String content;
    private Long   msgId;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

}
