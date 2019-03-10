package com.mic.thread.threadpool;


public class ThreadPoolDemo {

    private static  ThreadPool pool = new ThreadPool(10);

    public static void main(String[] args) throws InterruptedException {

        pool.shutdown();
        ThreadPoolDemo demo = new ThreadPoolDemo();
        demo.run();
        Thread.sleep(10*1000);

    }


    private void run() {
        for (int i = 0; i < 1000; i++) {
            XRunnable xRunnable = new XRunnable(i);
            pool.submit(xRunnable);
        }
    }


    private class XRunnable implements Runnable {

        private int index;

        public XRunnable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            int random = (int) (Math.random() * 10);
            System.out.println(Thread.currentThread().getName() + "-->running-->"+"--> index-->"+index+ "-->random-->"+random);
            try {
                Thread.sleep(random * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
