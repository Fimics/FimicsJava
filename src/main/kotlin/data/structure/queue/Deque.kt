package data.structure.queue

import data.structure.linkedlist.LinkedList
import data.structure.linkedlist.List

/**
 * 双向队列
 */
class Deque<E> {
    private val list: List<E> = LinkedList()
    fun size(): Int {
        return list.size()
    }

    val isEmpty: Boolean
        get() = list.isEmpty

    fun clear() {
        list.clear()
    }

    fun enQueueRear(element: E) {
        list.add(element)
    }

    fun deQueueFront(): E? {
        return list.remove(0)
    }

    fun enQueueFront(element: E) {
        list.add(0, element)
    }

    fun deQueueRear(): E? {
        return list.remove(list.size() - 1)
    }

    fun front(): E? {
        return list[0]
    }

    fun rear(): E? {
        return list[list.size() - 1]
    }
}