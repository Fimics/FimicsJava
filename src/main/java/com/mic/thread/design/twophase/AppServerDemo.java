package com.mic.thread.design.twophase;

import java.io.IOException;

/**
 * brew install telnet
 * telnet localhost port
 */
public class AppServerDemo {

    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer server = new AppServer(13345);
        server.start();

        Thread.sleep(15_000);
        server.shutdown();

    }
}
