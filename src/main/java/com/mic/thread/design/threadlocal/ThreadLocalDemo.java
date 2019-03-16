package com.mic.thread.design.threadlocal;

public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "default-value";
        }
    };


    public static void main(String[] args) {
        String value = threadLocal.get();
        System.out.println(value);
    }
}
