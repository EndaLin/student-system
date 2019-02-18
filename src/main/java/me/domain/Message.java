package me.domain;

import java.util.Map;

/**
 * @Author: wt
 * @Date: 2019/2/18 11:36
 */
public class Message {
    private int code;
    private String detail;
    private Map<String, String> message;

    public Message() {
        this.code = 1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }
}
