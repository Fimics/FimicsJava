package com.mic.thread.design.guardedsuspension;

/**
 * Guarded Suspension design pattern
 * request--> Tomcat httpserver ->doing
 * request --> Tomcat httpServer-->Queue
 */
public class SuspensionClient {
    public static void main(String[] args) throws InterruptedException {

         final String value = "hello";
         final RequestQueue queue = new RequestQueue();
         ClientThread client = new ClientThread(queue,value);
         ServerThread server = new ServerThread(queue);
         client.start();
         server.start();

        Thread.sleep(10000);
        server.close();

    }
}
