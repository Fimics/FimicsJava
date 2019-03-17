package com.mic.thread.design.twophase;

/**
 * two-phase termination design pattern
 */
public class TwoPhaseTerminationDemo {

    public static void main(String[] args) {

         CounterIncrement increment =new CounterIncrement();
         increment.start();

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        increment.close();
    }
}
