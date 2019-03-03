package com.mic.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class StreamCreatedDemo {
    public static void main(String[] args) {

        StreamCreatedDemo demo = new StreamCreatedDemo();
        demo.createStream();

    }


    private void createStream() {
        //1.
        Stream stream = Stream.of("java", "c");

        //2.
        String[] array = new String[]{"java", "python"};
        Stream stream1 = Stream.of(array);

        //3.
        List<String> list = new ArrayList<>();
        Stream stream2 = list.stream();

        IntStream.of(new int[]{1,4,6,9}).forEach(i->System.out.println(i));

        System.out.println("-----------------------");
        IntStream.range(3,9).forEach(System.out::println);
        System.out.println("-----------------------");
        IntStream.rangeClosed(3,9).forEach(System.out::println);
        System.out.println("-----------------------");

        System.out.println(
                IntStream.rangeClosed(1,100)
                        .map(i->i*1)
                        .reduce(0,Integer::sum)

        );


    }
}
