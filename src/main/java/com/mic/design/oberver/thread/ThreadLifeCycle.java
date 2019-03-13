package com.mic.design.oberver.thread;

public interface ThreadLifeCycle {
    void onEvent(ObservableRunnable.RunnableEvent event);
}