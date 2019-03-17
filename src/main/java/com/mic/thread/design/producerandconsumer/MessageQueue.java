package com.mic.thread.design.producerandconsumer;

import java.util.LinkedList;

public class MessageQueue {

    private final LinkedList<Message>  queue;

    private final static int DEFAULT_MAXLIMIT =100;

    private final int limit;

    public MessageQueue(){
        this(DEFAULT_MAXLIMIT);
    }

    public MessageQueue(final int limit) {
        this.queue = new LinkedList<Message>();
        this.limit=limit;
    }

    public void put(Message message) throws InterruptedException {
        synchronized (queue){
            while (queue.size()>limit){
                queue.wait();
            }

            queue.addLast(message);
            queue.notifyAll();
        }
    }


    public Message take() throws InterruptedException {
        synchronized (queue){
            while (queue.isEmpty()){
                queue.wait();
            }

            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }

    public int limit(){
        return this.limit;
    }

    public int size(){
      synchronized (queue){
          return queue.size();
      }
    }

}
