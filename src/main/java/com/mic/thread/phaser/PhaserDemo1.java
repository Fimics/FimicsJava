package com.mic.thread.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserDemo1 {

    private final static Random random = new Random();

    private static final Phaser phaser = new Phaser(5);

    public static void main(String[] args) {

//        Stream.of("A", "B", "C", "D", "E").forEach(s -> {
//            new Task(phaser);
//
//        });

        for (int i=1;i<6;i++){
            new Athletes(phaser,i);
        }
    }


    static class Athletes extends Thread {

        private final Phaser phaser;
        private final int index;

        public Athletes(Phaser phaser,int index) {
            this.phaser = phaser;
            this.index = index;
            start();
        }

        @Override
        public void run() {

            try {
                System.out.println(index + " start running .");
                TimeUnit.SECONDS.sleep(random.nextInt(2));
                System.out.println(index+" end running .");
                System.out.println("getPhase ->"+phaser.getPhase());
                phaser.arriveAndAwaitAdvance();


                System.out.println(index + " start jumping .");
                TimeUnit.SECONDS.sleep(random.nextInt(2));
                System.out.println(index+" end jumping  .");
                System.out.println("getPhase ->"+phaser.getPhase());
                phaser.arriveAndAwaitAdvance();

                System.out.println(index + " start jumping-long .");
                TimeUnit.SECONDS.sleep(random.nextInt(2));
                System.out.println(index+" end jumping-long  .");
                System.out.println("getPhase ->"+phaser.getPhase());
                phaser.arriveAndAwaitAdvance();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            phaser.arriveAndAwaitAdvance();
        }
    }
}
