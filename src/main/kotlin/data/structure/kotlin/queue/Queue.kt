package data.structure.kotlin.queue

import data.structure.kotlin.linkedlist.LinkedList
import data.structure.kotlin.linkedlist.List

/**
 * 队列 ，先进行出
 */
class Queue<E> {
    private val list: List<E> = LinkedList()
    fun size(): Int {
        return list.size()
    }

    val isEmpty: Boolean
        get() = list.isEmpty

    fun clear() {
        list.clear()
    }

    fun enQueue(element: E) {
        list.add(element)
    }

    fun deQueue(): E? {
        return list.remove(0)
    }

    fun front(): E? {
        return list[0]
    }
}