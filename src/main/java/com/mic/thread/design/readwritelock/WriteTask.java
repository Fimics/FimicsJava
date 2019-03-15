package com.mic.thread.design.readwritelock;

import java.util.Random;

public class WriteTask extends Thread {

    private static final Random random = new Random(System.currentTimeMillis());

    private final ShareData data;
    private final String filller;
    private int index;

    public WriteTask(ShareData shareData, String filller) {
        this.data = shareData;
        this.filller = filller;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                System.out.println(Thread.currentThread().getName() + " writes--> " + String.valueOf(c));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private char nextChar() {
        char c = filller.charAt(index);
        index++;
        if (index >= filller.length()) {
            index = 0;
        }
        return c;
    }
}
