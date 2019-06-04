package com.mic.thread.unsafe;

import org.junit.Before;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnSafeTest {

    Unsafe unsafe;

    @Before
    public void setUp() throws Exception {
        unsafe = getUnSafe();
        if (unsafe != null) {
            System.out.println(unsafe);
        }
    }

    @Test
    public void testUnSafe() {
        /*java.lang.SecurityException: Unsafe
        Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println(unsafe);
        */


        System.out.println(unsafe.addressSize());
    }

    @Test
    public void testExecutorService() {

        ExecutorService service = Executors.newFixedThreadPool(1000);

        /**
         *
         * Counter result : 10000000
         * Time passwd in ms :364
         * Time passwd in ms :337
         */
        //Counter counter = new StupiedCounter();

        /**
         * Counter result : 10000000
         * Time passwd in ms :647 619
         */
        //Counter counter = new SyncCounter();

        /**
         * Counter result : 10000000
         * Time passwd in ms :520
         */
        //Counter counter = new LockCounter();


        /**
         * Counter result : 10000000
         * Time passwd in ms :656
         */
        //Counter counter = new AtomicCounter();

        /**
         * Counter result : 10000000
         * Time passwd in ms :628
         */
        Counter counter = new CasCounter();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            service.submit(new CounterRunnable(counter, 10000));
        }

        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Counter result : " + counter.getCounter());
        System.out.println("Time passwd in ms :" + (end - start));

    }


    static class StupiedCounter implements Counter {

        private long counter = 0;


        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class SyncCounter implements Counter {

        private long counter = 0;


        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }


    static class LockCounter implements Counter {

        private long counter = 0;

        private final Lock lock = new ReentrantLock(false);
        @Override
        public  void increment() {

            try {
                lock.lock();
                counter++;
            }finally {
                lock.unlock();
            }

        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class AtomicCounter implements Counter {

        private AtomicLong counter = new AtomicLong(0);


        @Override
        public synchronized void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }
    }

    static class CasCounter implements Counter {

        private volatile  long counter =0;
        private Unsafe unsafe;
        private long offset;

        public CasCounter() {
            this.unsafe = getUnSafe();
            try {
                this.offset = unsafe.objectFieldOffset(CasCounter.class.getDeclaredField("counter"));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        @Override
        public  void increment() {
            long current = counter;
            while (!unsafe.compareAndSwapLong(this,offset,current,counter+1)){
                current = counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    private static Unsafe getUnSafe() {

        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    interface Counter {

        void increment();

        long getCounter();
    }

    static class CounterRunnable implements Runnable {

        private final Counter counter;
        private final int num;

        public CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }
}
