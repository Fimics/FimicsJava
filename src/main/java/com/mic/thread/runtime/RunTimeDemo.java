package com.mic.thread.runtime;

import java.util.Optional;

/**
 * hook
 * RunTime 可以运行一些命令
 */
public class RunTimeDemo {

    private static int i=0;

    public static void main(String[] args) {


        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("the application will be exit.");
            notifyAndRelease();
        }));


        while (true){
            try {
                Thread.sleep(1000);
                Optional.of("i -->"+i+"--->I am working...").ifPresent(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            i++;
            if(i>=5){
               // throw  new RuntimeException();
            }
        }
    }

    private static void  notifyAndRelease(){
        System.out.println("notify to the admin");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" will release resoutce(socket ,file ,connection)");

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" release done");
    }
}
