package com.mic.thread.design.future;

public class FutureClient {

    public static void main(String[] args) throws InterruptedException {

        FutureService service = new FutureService();
        service.submit(() -> {


            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(20 * 1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "FINISH";

        },System.out::println);


        System.out.println("========================");
        System.out.println("do other thing.");
        Thread.sleep(100);
        System.out.println("=================");

        //System.out.println(future.get());

        System.out.println("do other thing---1.");

    }
}
