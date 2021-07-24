package com.hellofriendz.messagesapp;

import java.io.Serializable;

public class MessageClass implements Serializable {
    private String Number;
    private String Message;

    public  MessageClass(String n,String m)
    {
        this.Message=m;
        this.Number=n;
    }

    public String getMessage() {
        return Message;
    }

    public String getNumber() {
        return Number;
    }
}
