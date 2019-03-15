package com.mic.thread.design.readwritelock;

/**
 * 1. BooleanLock 可以中断
 * 2. ReaderWriterLocak
 * 2.1 read 所有的线程都是在读数据(数据不会改变）就不用加锁
 * 2.2 write 只有在修改数据才加锁
 * 3.读写锁分离考虑的问题
 * 3.1 read 并行化
 * 3.2 写的过程不允许读
 * 3.3 写的过程不允许再写
 */

@SuppressWarnings("unused")
public class ReadWriteLock {

    /**
     * 当前正在写的线程数
     */
    private int readingCount;

    /**
     * 当前想读的线程数（想读不能读，放到waitset中）
     */
    private int waitingReadCount;

    /**
     * 当前正在写的线程数，0|1
     */
    private int writingCount;

    /**
     * 当前想写的线程数，但不能写 放在waitSet中
     */
    private int waitWriteCount;

    /**
     * 解决读多写少的问题
     */
    private boolean isLikeWriter = true;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean isLikeWriter) {
        this.isLikeWriter = isLikeWriter;
    }

    public synchronized void readLock(){
       this.waitingReadCount++;

       try {
           //有线程正在写数据
          // while (writingCount>0 ||(isLikeWriter&&waitWriteCount>0)){
           while (writingCount>0 ||isLikeWriter){
               this.wait();
           }
           //如果没人写，就可以读了
           this.readingCount++;
       } catch (InterruptedException e) {
           e.printStackTrace();
       } finally {
           this.waitingReadCount--;
       }

    }

    public synchronized void readUnLock(){
        this.readingCount--;
        this.notifyAll();
    }

    public synchronized void writeLock(){
          this.waitWriteCount++;

          try {
              //如果有人正在读数据，或有人正在写数据 就wait
              while (waitingReadCount>0||readingCount>0){
                this.wait();
              }
              this.waitWriteCount++;
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              this.waitingReadCount--;
          }

    }

    public synchronized void writeUnLock(){
         this.writingCount--;
         this.notifyAll();
    }

}
