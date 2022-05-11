package com.mic.design.oberver.thread;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public class ThreadObserver implements ThreadLifeCycle {

    private final Object lock = new Object();

    public void concurrentQuery(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return;
        }

        ids.stream().map(id -> new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {

                try {
                    notifyChanged(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    Optional.of("query for the id -->" + id).ifPresent(System.out::println);
                    Thread.sleep(1000);

                    int a = 4 / 0;
                    notifyChanged(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    notifyChanged(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), e));
                }
            }
        })).forEach(thread -> thread.start());
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (lock) {
            System.out.println("The runnable [ " + event.getThread().getName() + " ] data changed and state is [ " + event.getState() + " ]");

            if (event.getCause() != null) {
                System.out.println("The runnable [ " + event.getThread().getName() + " ] process failed.");
                event.getCause().printStackTrace();
            }
        }
    }
}
