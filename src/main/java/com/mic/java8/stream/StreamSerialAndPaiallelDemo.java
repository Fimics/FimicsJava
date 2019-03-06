package com.mic.java8.stream;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 串行流与并行流
 */
public class StreamSerialAndPaiallelDemo {

    private static int count =5000000;

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(count);

        for(int i=0;i<count;i++){
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("start sort");

        long startTime = System.nanoTime();

        //list.stream().sorted().count();
        list.parallelStream().sorted().count();

        long endTime =System.nanoTime();

        long totalTime = endTime-startTime;
        System.out.println("use time :" + TimeUnit.NANOSECONDS.toMillis(totalTime));
    }
}
