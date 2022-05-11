package com.mic.design.singleton;

@SuppressWarnings("unused")
public class EnumSingleton {

    private EnumSingleton() {
    }

    private enum Holder{
        INSTANCE;

        private final EnumSingleton instance;

        private Holder() {
            instance = new EnumSingleton();
        }

        public EnumSingleton getInstance(){
            return instance;
        }
    }

    public static EnumSingleton getInstance(){
        return  Holder.INSTANCE.getInstance();
    }
}
