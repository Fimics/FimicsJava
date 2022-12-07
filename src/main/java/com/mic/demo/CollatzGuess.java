package com.mic.demo;

import kotlin.Pair;

import java.util.*;

/**
 * collatz猜想
 */
public class CollatzGuess {

    public static void main(String[] args) {
        GuessMax guessMax = new GuessMax(1,1000);
        guessMax.max();
        guessMax.printMaxStep();
    }

    private static class GuessMax {
        private int from = 0;
        private int to = 0;
        private List<Pair<Integer, Integer>> list = new ArrayList<>();
        private Guess guess;

        public GuessMax(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public void max() {
            if (from >= to) return;

            for (int i = from; i < to; i++) {
                guess = new Guess(i);
                guess.guess();
//                guess.pick();
                int stepCount = guess.stepCount();
                list.add(new Pair<Integer, Integer>(i, stepCount));
            }
        }

        public void printMaxStep() {
            Collections.sort(list, (o1, o2) -> o2.getSecond() - o1.getSecond());
            int size = list.size();
            System.out.println("maxIndex->" + list.get(0).getFirst() + "  maxValue->" + list.get(0).getSecond());
            System.out.println("minIndex->" + list.get(size - 1).getFirst() + "  minValue->" + list.get(size - 1).getSecond());
        }

    }

    private static class Guess {
        private int currentNumber;
        private ArrayList<Integer> list = new ArrayList<>();

        public Guess(int initNUm) {
            this.currentNumber = initNUm;
            list.add(currentNumber);
        }

        public void guess() {
            while (currentNumber != 0 && currentNumber != 1) {
                if (isEven(currentNumber)) {
                    currentNumber = currentNumber / 2;
                } else {
                    currentNumber = currentNumber * 3 + 1;
                }
                list.add(currentNumber);
            }
        }

        public void pick() {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int n = list.get(i);
                System.out.print(n + "->");
            }
            System.out.println();
            System.out.println("step-> " + size);
        }

        public int stepCount() {
            return list.size()-1;
        }

        private boolean isEven(int number) {
            return number % 2 == 0;
        }
    }
}
