package com.mic.thread.design.producerandconsumer;

public class Message {

    private String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
