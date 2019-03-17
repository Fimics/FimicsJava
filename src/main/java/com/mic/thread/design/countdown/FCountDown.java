package com.mic.thread.design.countdown;

public class FCountDown {

    private final int total;
    private int counter=0;

    public FCountDown(int total) {
        this.total = total;
    }

    public void down(){
        synchronized (this){
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this){
            while (counter!=total){
                this.wait();
            }
        }
    }
}
