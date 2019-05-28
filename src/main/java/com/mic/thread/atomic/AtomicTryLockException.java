package com.mic.thread.atomic;

public class AtomicTryLockException extends Exception{

    public AtomicTryLockException() {
        super();
    }

    public AtomicTryLockException(String msg) {
        super(msg);
    }
}
