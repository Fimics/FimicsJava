package com.mic.generics;

import java.util.ArrayList;
import java.util.List;

// 协变（covariant）与逆变（contravariant）
//PECS ? extends x -> out 从x读取数据  , ? super x-> in 向x写人数据
public class GenPECS1 {
    public static void main(String[] args) {
        //在Java中数组是协变的，下面的代码是可以正确编译运行的
        Integer[] ints = new Integer[3];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        Number[] numbers = new Number[3];
        numbers = ints;
        for (Number n : numbers) {
            System.out.println(n);
        }

        /**
         * 在Java中，因为 Integer 是 Number 的子类型，数组类型 Integer[] 也是 Number[] 的子类型，
         * 因此 在任何需要 Number[] 值的地方都可以提供一个 Integer[] 值。 而另一方面，泛型不是协变的。
         * 也就是说， List 不是 List 的子类型，试图在要求 List 的位置提供 List 是一个类型错误。
         * 下面的代码，编译器是会直接报错的：
         */
        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        List<Number> numberList = new ArrayList<>();
//        numberList = integerList; error

        // Wildcard type for parameter that serves as an E producer
//        public void pushAll (Iterable < ? extends E > src){
//            for (E e : src) // out T, 从src中读取数据，producer-extends push(e);
//            }

        // Wildcard type for parameter that serves as an E consumer
        // public void popAll(Collection<? super E> dst) {
        // while (!isEmpty()) dst.add(pop());
        // in T, 向dst中写入数据， consumer-super }

    }

    //在 java.util.Collections 的 copy 方法中(JDK1.7)完美地诠释了PECS：
//    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
//        int srcSize = src.size();
//        if (srcSize > dest.size())
//            throw new IndexOutOfBoundsException("Source does not fit in dest");
//        if (srcSize < COPY_THRESHOLD
//                || (src instanceof RandomAccess
//                && dest instanceof RandomAccess)) {
//            for (int i = 0; i < srcSize; i++)
//                dest.set(i, src.get(i));
//        } else {
//            ListIterator<? super T> di = dest.listIterator();// in T, 写入dest数据
//            ListIterator<? extends T> si = src.listIterator(); // out T， 读取src数据
//            for (int i = 0; i < srcSize; i++) {
//                di.next();
//                di.set(si.next());
//            }
//        }
//    }
}

