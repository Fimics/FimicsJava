package com.mic.thread.readwritelock;

public class ReadTask extends Thread {

    private final ShareData data;

    public ReadTask(ShareData data) {
        this.data = data;
    }

    @Override
    public void run() {

        while (true) {
            char[] readBuf = data.read();
            System.out.println(Thread.currentThread().getName() + " reads--> " + String.valueOf(readBuf));
        }

    }
}
