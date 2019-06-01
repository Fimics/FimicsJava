package com.mic.thread.atomic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    AtomicIntegerArray array;

    @Before
    public void setUp() throws Exception {
        array = new AtomicIntegerArray(10);
    }

    @Test
    public void testArray() {
        System.out.println(array.get(0));
        Assert.assertEquals(10,array.length());
    }
}
