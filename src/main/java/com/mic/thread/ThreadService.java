package com.mic.thread;


public class ThreadService {

    //执行线程退出，守护线程就会退出
    private Thread executeThread;
    private boolean isFinished;

    public static void main(String[] args) {

        ThreadService service = new ThreadService();
        service.execute(new XTask());
        service.shutdown(1000);
    }

    private static class XTask implements  Runnable{

        int i =0;
        @Override
        public void run() {

           for (;;){
               try {
                   Thread.currentThread().sleep(100);
                   System.out.println("---------: "+i++);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

        }
    }

    public void execute(Runnable task){

       executeThread = new Thread(()->{

           Thread runner = new Thread(task);
           runner.setDaemon(true);
           runner.start();
           try {
               runner.join();
               isFinished = true;
           } catch (InterruptedException e) {
               e.printStackTrace();
               System.out.println("thread end");
           }


       });

       executeThread.start();

    }


    public void shutdown(int mills){
        long currentTime = System.currentTimeMillis();

        while (!isFinished){
            if (System.currentTimeMillis()-currentTime>=mills){
                System.out.println("task timeout");
                executeThread.interrupt();
                break;
            }

            try {
                executeThread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
