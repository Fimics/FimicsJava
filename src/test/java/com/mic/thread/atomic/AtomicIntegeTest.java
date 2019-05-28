package com.mic.thread.atomic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

//
public class AtomicIntegeTest {
    AtomicInteger atomic;
    AtomicInteger atomic2;
    @Before
    public void setUp() throws Exception {
         atomic = new AtomicInteger();
         atomic2 = new AtomicInteger(5);
    }

    @Test
    public void test(){

        System.out.println(atomic.get());
        System.out.println(atomic2.get());
        atomic.set(10);
        System.out.println(atomic.get());

        atomic.lazySet(111);
        System.out.println(atomic.get());
    }

    @Test
    public void testGetAndSet() {
        System.out.println(atomic.getAndIncrement());
        System.out.println(atomic.getAndDecrement());
        System.out.println(atomic.addAndGet(33));
        System.out.println(atomic.decrementAndGet());

        System.out.println(atomic.doubleValue());
        /**
         * 使用最快失败的方式，而不是加锁的方式
         */
        System.out.println(atomic.compareAndSet(34,33));
        System.out.println(atomic.getAndAdd(22));
        System.out.println(atomic.getAndSet(55));
    }

    @After
    public void tearDown() throws Exception {

    }
}
