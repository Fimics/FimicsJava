package com.mic.thread.design.workerthread;

public class WorkerThreadDemo {
    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWork();

        new TransportThread("A------>>",channel).start();
        new TransportThread("<--------------B",channel).start();
        new TransportThread("C===>",channel).start();
    }
}
