package com.mic.thread.design.future;

public interface Future<T> {

    /**
     * 得到真正想要的结果
     * @return
     * @throws InterruptedException
     */
    T get() throws InterruptedException;
}
