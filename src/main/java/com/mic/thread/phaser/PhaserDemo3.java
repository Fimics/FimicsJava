package com.mic.thread.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PhaserDemo3 {

    private final static Random random = new Random();

    private static final Phaser phaser = new Phaser();

    public static void main(String[] args) {

//        Stream.of("A", "B", "C", "D", "E").forEach(s -> {
//            new Task(phaser);
//
//        });

        IntStream.rangeClosed(1,5).boxed().map(i->phaser).forEach(Task::new);

        phaser.register();
        phaser.arriveAndAwaitAdvance();
        System.out.println("all work finished");
    }


    static class Task extends Thread {

        private final Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
            this.phaser.register();
            start();
        }

        @Override
        public void run() {

            try {
                System.out.println(getName() + " working.");
                TimeUnit.SECONDS.sleep(random.nextInt(10));
                System.out.println(getName()+" finished ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            phaser.arriveAndAwaitAdvance();
        }
    }
}
