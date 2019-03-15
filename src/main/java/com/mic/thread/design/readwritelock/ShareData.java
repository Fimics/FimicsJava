package com.mic.thread.design.readwritelock;

/**
 * share -data
 */
@SuppressWarnings("unused")
public class ShareData {

    private final char [] buffer;

    private final ReadWriteLock lock = new ReadWriteLock();

    public ShareData(int size) {
        this.buffer = new char[size];

        for(int i=0;i<buffer.length;i++){
            buffer[i]= '*';
        }
    }

    public char[] read(){
        try {
            lock.readLock();
            return doRead();
        }finally {
            lock.readUnLock();
        }
    }

    private char[] doRead(){
       char[] newbuf = new char[buffer.length];
       for(int i=0;i<buffer.length;i++){
           newbuf[i]=buffer[i];
       }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return newbuf;
    }

    public void write(char c){
        try {
            lock.writeLock();
            doWrite(c);
        }finally {
            lock.writeUnLock();
        }
    }

    public void doWrite(char c){
      for (int i=0;i<buffer.length;i++){
          buffer[i]=c;
          try {
              Thread.sleep(50);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }
}
