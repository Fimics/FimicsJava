package com.mic.thread.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserDemo2 {

    private final static Random random = new Random();

    private static final Phaser phaser = new Phaser(5);

    public static void main(String[] args) {

//        Stream.of("A", "B", "C", "D", "E").forEach(s -> {
//            new Task(phaser);
//
//        });

        for (int i=1;i<5;i++){
            new Athletes(phaser,i);
        }

        new AthletesBad(phaser,5);
    }
    static class AthletesBad extends Thread {

        private final Phaser phaser;
        private final int index;

        public AthletesBad(Phaser phaser,int index) {
            this.phaser = phaser;
            this.index = index;
            start();
        }

        @Override
        public void run() {

            try {
                sport(phaser,index+" start running ..", index+" end running .");

                sport(phaser,index+" start jumping .", index+" end jumping  .");

                System.out.println(index+ "  i am bad ...");
                /**
                 * 运行时出现异常，可以取消
                 */
                phaser.arriveAndDeregister();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
                sport(phaser,index+" start running ..", index+" end running .");

                sport(phaser,index+" start jumping .", index+" end jumping  .");

                sport(phaser,index+" start jumping-long .", index+" end jumping-long  .");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sport(Phaser phaser,String s, String s2) throws InterruptedException {
        System.out.println(s);
        TimeUnit.SECONDS.sleep(random.nextInt(2));
        System.out.println(s2);
        phaser.arriveAndAwaitAdvance();
    }
}
