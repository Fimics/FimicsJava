package com.mic.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreatedDemo {
    public static void main(String[] args) {
        //1.
        Stream stream = Stream.of("java","c");

        //2.
        String [] array = new String []{"java","python"};
        Stream stream1 = Stream.of(array);

        List<String> list = new ArrayList<>();
        Stream stream2 = list.stream();

    }
}
