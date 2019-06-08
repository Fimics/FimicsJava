package com.mic.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class RecursiveTaskDemo {


    private static final int MAX_THRESHOLD =3;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask future =pool.submit(new CalculatedRecursiveTask(1,1000));
        System.out.println(future.get());

    }


    private static class CalculatedRecursiveTask extends RecursiveTask<Integer>{

        private final int start;
        private final int end;

        CalculatedRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            if(end-start<=MAX_THRESHOLD){
                return IntStream.rangeClosed(start,end).sum();
            }else{
                int middle = (start+end)/2;
                CalculatedRecursiveTask leftTask = new CalculatedRecursiveTask(start,middle);
                CalculatedRecursiveTask rightTask = new CalculatedRecursiveTask(middle+1,end);
                leftTask.fork();
                rightTask.fork();

                return leftTask.join()+rightTask.join();
            }
        }
    }
}
