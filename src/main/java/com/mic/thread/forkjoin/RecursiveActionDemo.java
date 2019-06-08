package com.mic.thread.forkjoin;

import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class RecursiveActionDemo {


    private static final int MAX_THRESHOLD =3;
    private static final AtomicInteger SUM = new AtomicInteger(0);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new CalculatedRecursiveAction(1,100));
        pool.awaitTermination(10,TimeUnit.SECONDS);
        Optional.of(SUM).ifPresent(System.out::println);

    }


    private static class CalculatedRecursiveAction extends RecursiveAction {

        private final int start;
        private final int end;

        CalculatedRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            if(end-start<=MAX_THRESHOLD){
                SUM.addAndGet(IntStream.rangeClosed(start,end).sum());
            }else{
                int middle = (start+end)/2;
                CalculatedRecursiveAction leftTask = new CalculatedRecursiveAction(start,middle);
                CalculatedRecursiveAction rightTask = new CalculatedRecursiveAction(middle+1,end);
                leftTask.fork();
                rightTask.fork();
            }
        }
    }
}
