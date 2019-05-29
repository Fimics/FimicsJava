package com.mic.thread.atomic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {

    AtomicLong a;

    /**
     * static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
     * 1.数据总线  传的数据  long 是64位的，分成两个32位的传两次，（分高低位），这个过程不能保证原子性的
     * 2.控制总线  CPU指令
     * 3.地址总线  内存地址
     */

    @Before
    public void setUp() throws Exception {
        a = new AtomicLong(100);
    }

    @Test
    public void testLong() {
        System.out.println(a.get());
        System.out.println(a.decrementAndGet());
        System.out.println(a.doubleValue());
    }

    @After
    public void tearDown() throws Exception {

    }
}
