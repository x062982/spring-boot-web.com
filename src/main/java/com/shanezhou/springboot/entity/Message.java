package com.shanezhou.springboot.entity;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/12 星期三
 */
public class Message {

    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
