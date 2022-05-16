package com.mic.kotlin;

import com.mic.p13_kotlinjava.KExtensionListKt;

import java.util.ArrayList;
import java.util.List;

public class JavaCallKotlinKExtension {
    public static void main(String[] args) {
        List<String> list = KExtensionListKt.myFilter(new ArrayList<>());
        System.out.println(list);

        List<Integer> list2 = KExtensionListKt.myFilter2(new ArrayList<>());
        System.out.println(list2);
    }
}
