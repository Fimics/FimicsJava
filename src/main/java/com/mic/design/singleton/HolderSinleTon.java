package com.mic.design.singleton;

@SuppressWarnings("unused")
public class HolderSinleTon {

    private HolderSinleTon() {
    }

    private static class Holder{
        private static final  HolderSinleTon instance = new HolderSinleTon();
    }

    public static HolderSinleTon getInstance(){
        return Holder.instance;
    }
}
