package com.mic.thread.tvolatile;

public class VolatileDemo {

    private volatile static int INIT_VALUE =0;
    private final static int MAX_LIMIT =5;

    public static void main(String[] args) {

        VolatileDemo demo = new VolatileDemo();
        demo.writeData();
        demo.readData();
    }

    private void readData(){

        new Thread(()->{
            int localValue = INIT_VALUE;
            while (localValue<MAX_LIMIT){
                if(localValue!=INIT_VALUE){
                    System.out.printf("The value update to [%d]\n",INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        },"READER").start();

    }

    private void writeData(){

        new Thread(()->{
            int localValue =INIT_VALUE;
            while (INIT_VALUE<MAX_LIMIT){
                System.out.printf("Update the value to [%d]\n",++localValue);
                INIT_VALUE=localValue;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"UPDATE").start();
    }
}
