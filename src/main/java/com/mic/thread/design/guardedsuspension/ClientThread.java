package com.mic.thread.design.guardedsuspension;


import java.util.Random;

public class ClientThread extends Thread {

    private final RequestQueue queue;
    private final Random random;
    private final String value;

    public ClientThread(RequestQueue queue,String sendValue) {
        this.queue = queue;
        this.value=sendValue;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("client--> request "+value);
            queue.putRequest(new Request(value));
            try {
                sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
