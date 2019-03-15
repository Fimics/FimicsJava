package com.mic.thread.design.future;

public interface FutureTask<T> {

    /**
     * 真正做事情的方法
     * @return
     */
    T call();
}
