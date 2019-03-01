package com.mic.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMAnalyse {


    public static void main(String args []){
        List<Demo> list = new ArrayList<Demo>();
//        while (true){
//            list.add(new Demo());
//        }

    }


    private static class Demo{
        private String a="";
    }
}
