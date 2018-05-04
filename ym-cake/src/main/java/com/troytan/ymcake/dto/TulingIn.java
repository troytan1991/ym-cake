package com.troytan.ymcake.dto;

public class TulingIn {

    private String key;
    private String info;
    private String userid;

    public TulingIn(String key, String info, String userid){
        super();
        this.key = key;
        this.info = info;
        this.userid = userid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getuserid() {
        return userid;
    }

    public void setuserid(String userid) {
        this.userid = userid;
    }

}
