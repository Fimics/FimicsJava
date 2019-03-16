package com.mic.thread.design.guardedsuspension;

import java.util.LinkedList;

@SuppressWarnings("unused")
public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest(){
        synchronized (queue){
            while (queue.size()<=0){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    queue.notifyAll();
                    return null;
                }
            }
        }

        return queue.removeFirst();
    }


    public void putRequest(Request request){
        synchronized (queue){
            queue.addLast(request);
            queue.notifyAll();
        }
    }

    public int size(){
        synchronized (queue){
            return queue.size();
        }
    }
}
