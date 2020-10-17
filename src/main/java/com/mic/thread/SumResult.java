package com.mic.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SumResult {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 选一个大型数组
        int length = 100;
        long[] array = new long[length];
        for (int i = 0; i < length; i++) {
            array[i] = i+1;
            System.out.println(array[i]);
        }



        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Long>> ans = executor.invokeAll(
                Arrays.asList(new Sum(1,50),new Sum(51,100))
        );


        long sum = 0;
        for (Future<Long> i :ans){
            long tmp = i.get();
            sum+=tmp;
        }

        System.out.println(sum);
    }

        public static class  Sum implements Callable<Long>{

        private final Long from;
        private final Long to;

        //区域数字相加
        public Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        //线程返回值函数
        @Override
        public Long call() throws Exception {
            long result = 0;
            for (long i = from; i <= to; i++)
                result += i;

            return result;
        }

    }
}
