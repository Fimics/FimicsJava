package leetcode.queue

import java.util.*

/**
 * 用栈实现队列
 */

class QueueWithStack {
    private val inStack: Stack<Int> = Stack()
    private val outStack: Stack<Int> = Stack()

    /** 入队  */
    fun push(x: Int) {
        inStack.push(x)
    }

    /** 出队  */
    fun pop(): Int {
        checkOutStack()
        return outStack.pop()
    }

    /** 获取队头元素  */
    fun peek(): Int {
        checkOutStack()
        return outStack.peek()
    }

    /** 是否为空  */
    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }

    private fun checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop())
            }
        }
    }

}