package com.mic.thread.threadpool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1.任务队列
 * 2.拒绝侧略（抛出异常，直接丢弃，阻塞，临时队列）
 * 3.init(min)
 * 4.active
 * 5.max
 */

@SuppressWarnings("unused")
public class ThreadPool {

    private static final int DEFAULT_SIZE = 10;
    private static final int MAX_SIZE = 128;
    private static final int QUEUE_SIZE=20;
    private int size = 10;
    private static volatile int seq;

    private ThreadGroup group = new ThreadGroup("thread-pool--:");
    private List<WorkerTask> tasks = new ArrayList<>();
    private final static LinkedList<Runnable> taskQueue = new LinkedList<>();
    private static final LinkedList<Runnable> tempTaskQueue = new LinkedList<>();

    private final DiscardPolicy DEFAULT_POLICY = () -> {
        throw new DiscardException("that threadpool size too large to no Supported and max size is:"+MAX_SIZE);
    };


    public ThreadPool() {
        this(10);
    }

    public ThreadPool(int size) {

        if(size>MAX_SIZE){
            DEFAULT_POLICY.discard();
            return;
        }

        this.size = size;
        for (int i = 0; i < size; i++) {
            createWorkerTask("Task");
        }
    }

    private void createWorkerTask(String name) {
        WorkerTask workerTask = new WorkerTask(group, name + "-->" + seq++);
        workerTask.start();
        tasks.add(workerTask);
    }

    public void submit(Runnable runnable) {
        synchronized (taskQueue) {
            if(!isFull()){
                taskQueue.addLast(runnable);
                taskQueue.notifyAll();
                System.out.println("taskQueue.addLast****************************-->");
            }else {
                tempTaskQueue.addLast(runnable);
                System.out.println("tempTaskQueue.addLast--------------------->");
            }
        }
    }


    public void shutdown()  {
        synchronized (taskQueue) {
            taskQueue.clear();
            tasks.stream().forEach(t -> {
                try {
                    t.interrupt();
                    t.cancel();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

            tempTaskQueue.clear();
            taskQueue.clear();
            System.out.println("shutdownshutdownshutdownshutdownshutdownshutdownshutdownshutdownshutdownshutdownshutdownshutdownshutdown");
        }
    }

    private boolean isFull(){
        return taskQueue.size()==QUEUE_SIZE;
    }

    public class DiscardException extends RuntimeException {
        public DiscardException(String message) {
            super(message);
        }
    }

    public interface DiscardPolicy {
        void discard() throws DiscardException;
    }

    /**
     * TaskState
     */
    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD;
    }

    /**
     * WorkTask
     */
    public class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            Outer:
            while (this.taskState != TaskState.DEAD) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {

                        try {
                            taskState = TaskState.BLOCKED;
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break Outer;
                        }
                    }

                    Runnable runnable = taskQueue.removeFirst();
                    if(!isFull() && !tempTaskQueue.isEmpty()){
                        Runnable tempRunnable = tempTaskQueue.removeFirst();
                        System.out.println("tempTaskQueue.removeFirst===================>");
                        taskQueue.addLast(tempRunnable);
                    }

                    if (runnable != null) {
                        taskState = TaskState.RUNNING;
                        runnable.run();
                        taskState = TaskState.FREE;
                    }
                }
            }
        }

        public void cancel() {
            this.taskState = TaskState.DEAD;
        }

        public TaskState getTaskState() {
            return taskState;
        }

        public void setTaskState(TaskState taskState) {
            this.taskState = taskState;
        }

    }

}
