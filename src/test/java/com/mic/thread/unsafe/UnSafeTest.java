package com.mic.thread.unsafe;

import org.junit.Before;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

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
}
