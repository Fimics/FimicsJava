package com.mic.design.oberver.thread;

/**
 * Observer to monitor the Thread lifecycle
 */
@SuppressWarnings("unused")
public abstract class ObservableRunnable implements Runnable {

    final protected ThreadLifeCycle threadLifeCycle;

    public ObservableRunnable(ThreadLifeCycle threadLifeCycle) {
        this.threadLifeCycle = threadLifeCycle;
    }

    protected void notifyChanged(final RunnableEvent event) {
        threadLifeCycle.onEvent(event);
    }

    public enum RunnableState {
        RUNNING, ERROR, DONE;
    }

    public static class RunnableEvent {

        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }


}
