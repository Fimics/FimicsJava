package com.mic.thread.executor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerScheduler {

    /**
     * scheduler solution
     *   Timer/TimerTask
     *   SchedulerExecutorService
     *   crontab
     *   cron4j
     *   quartz
     */
    public static void main(String[] args) {

        Timer timer = new Timer();
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("-----");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        /**
         * 每隔1s执行一次任务，如果执行的task超过1s,时间间隔就不准了
         */
        timer.scheduleAtFixedRate(task,0,1000);

    }
}
