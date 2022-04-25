package data2.stuucture.sequence;


import data2.stuucture.sequence.tools.Asserts;

public class Main {
    public static void main(String[] args) {
        Asserts.test(BruteForce01.indexOf("hello world","or")==7);
        System.out.println(BruteForce01.indexOf("hello world","or"));
        System.out.println(KMP.indexOf("hello world","or"));
//        System.out.println(KMP.indexOf("hello world","or")==7);
    }
}
