package com.mic.java8.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {


    public static void main(String[] args) {

        JFrame frame = new JFrame("Frame");
        JButton button = new JButton("click");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click");
            }
        });

        button.addActionListener((ActionEvent e) -> {
            System.out.println("click-event");
            System.out.println("button-event");
        });

        //没写ActionEvent 是因为java 编译器推断出来的，并不是所有类型都能推断出来，如果不能推断出来，要手写类型
        button.addActionListener(e -> {
            System.out.println("click-event");
            System.out.println("button-event");
        });

        frame.add(button);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
