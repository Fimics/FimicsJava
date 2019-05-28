package com.mic.thread.atomic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {

    AtomicBoolean b1;
    AtomicBoolean b2;

    @Before
    public void setUp() throws Exception {
        b1 = new AtomicBoolean();
        b2 = new AtomicBoolean(true);
    }

    @Test
    public void testGetAndSet() {
        System.out.println(b1.get());
        System.out.println(b2.get());
        Assert.assertFalse(b1.get());
        Assert.assertTrue(b2.get());
        System.out.println(b2.compareAndSet(true,false));
        b1.set(true);
        System.out.println(b1.get());
        b1.getAndSet(false);
        System.out.println(b1.get());
    }

    @After
    public void tearDown() throws Exception {

    }
}
