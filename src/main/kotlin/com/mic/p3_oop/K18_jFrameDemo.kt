package com.mic.p3_oop

import java.awt.event.ActionListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.JButton
import javax.swing.JFrame

fun main() {
    val jFrame = JFrame("My JFrame")
    val jButton = JButton("My JButton")

    jFrame.addWindowListener(object: WindowListener {

        override fun windowDeiconified(e: WindowEvent?) {
        }


        override fun windowClosing(e: WindowEvent?) {
            println("windowClosing")
        }


        override fun windowClosed(e: WindowEvent?) {
        }


        override fun windowActivated(e: WindowEvent?) {
            println("windowActivated")
        }


        override fun windowDeactivated(e: WindowEvent?) {
        }


        override fun windowOpened(e: WindowEvent?) {
            println("windowOpened")
        }


        override fun windowIconified(e: WindowEvent?) {
        }
    })

    /*
        如果对象是Java函数式接口的一个实例（即只拥有一个抽象方法的接口），
        那么可以通过Lambda表达式来调用，其中Lambda表达式前面加上接口的类型。
     */
//    jButton.addActionListener(object: ActionListener {
//        override fun actionPerformed(e: ActionEvent?) {
//            println("Button Pressed")
//        }
//    })

    jButton.addActionListener({ println("Button Pressed") })

    val listener = ActionListener { println("hello world") }
    println(listener.javaClass)
    println(listener.javaClass.superclass)

    println(listener::class.java)
    println(listener::class.java.superclass)


    jFrame.add(jButton)
    jFrame.pack()
    jFrame.isVisible = true
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}