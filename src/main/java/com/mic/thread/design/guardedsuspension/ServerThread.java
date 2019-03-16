package com.mic.thread.design.guardedsuspension;

import java.util.Random;

public class ServerThread extends Thread {

    private final RequestQueue queue;
    private final Random random;
    private volatile  boolean flag = false;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        random=new Random(System.currentTimeMillis());
    }


    @Override
    public void run() {
        while (!flag){
            System.out.println("queue size of --> "+queue.size());
            Request request =queue.getRequest();
            if(null==request){
                System.out.println("received the empty request.");
                continue;
            }
            System.out.println("server-->"+request.getValue());
            try {
                sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void close(){
        this.flag=true;
        this.interrupt();
    }
}
