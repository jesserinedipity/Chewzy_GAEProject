package com.chewzy.model;

/**
 * Created by Misa on 10/1/2016.
 */
public class Message {
    public String message;
    public boolean flag;

    public Message(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Message(String message, boolean flag) {

        this.message = message;
        this.flag = flag;
    }
}
