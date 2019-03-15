package com.mic.thread.design.future;

import java.util.function.Consumer;

/**
 * 桥接类
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> futureTask){

           AsynFuture<T> asynFuture = new AsynFuture<>();

          new Thread(()-> {
              T result = futureTask.call();
              asynFuture.done(result);
          }).start();

          return asynFuture;
    }

    public <T> Future<T> submit(final FutureTask<T> futureTask, final Consumer<T> consumer){

        AsynFuture<T> asynFuture = new AsynFuture<>();

        new Thread(()-> {
            T result = futureTask.call();
            consumer.accept(result);
            asynFuture.done(result);
        }).start();

        return asynFuture;
    }
}
