package data.structure.kotlin.linkedlist

class BothCircleLinkedList<E> : AbstractList<E>() {
    private var first: Node<E?>? = null
    private var last: Node<E?>? = null
    private var current: Node<E?>? = null

    private class Node<E>(var prev: Node<E>?, var element: E, var next: Node<E>?) {
    }

    fun reset() {
        current = first
    }

    operator fun next(): E? {
        if (current == null) return null
        current = current?.next
        return current!!.element
    }

    fun remove(): E? {
        if (current == null) return null
        val next = current?.next!!
        val element = remove(current)
        current = if (size == 0) {
            null
        } else {
            next
        }
        return element
    }

    override fun clear() {
        size = 0
        first = null
        last = null
    }

    override fun get(index: Int): E? {
        return node(index)!!.element
    }

    override fun set(index: Int, element: E): E? {
        val node = node(index)
        val old = node!!.element
        node.element = element
        return old
    }

    override fun add(index: Int, element: E) {
        rangeCheckForAdd(index)

        // size == 0
        // index == 0
        if (index == size) { // 往最后面添加元素
            val oldLast = last
            last = Node(oldLast, element, first)
            if (oldLast == null) { // 这是链表添加的第一个元素
                first = last
                first!!.next = first
                first!!.prev = first
            } else {
                oldLast.next = last
                first!!.prev = last
            }
        } else {
            val next = node(index)
            val prev = next!!.prev
            val node = Node(prev, element, next)
            next.prev = node
            prev!!.next = node
            if (next === first) { // index == 0
                first = node
            }
        }
        size++
    }

    override fun remove(index: Int): E? {
        rangeCheck(index)
        return remove(node(index))
    }

    private fun remove(node: Node<E?>?): E? {
        if (size == 1) {
            first = null
            last = null
        } else {
            val prev = node!!.prev
            val next = node.next
            prev!!.next = next
            next!!.prev = prev
            if (node === first) { // index == 0
                first = next
            }
            if (node === last) { // index == size - 1
                last = prev
            }
        }
        size--
        return node!!.element
    }

    override fun indexOf(element: E?): Int {
        if (element == null) {
            var node = first
            for (i in 0 until size) {
                if (node!!.element == null) return i
                node = node.next
            }
        } else {
            var node = first
            for (i in 0 until size) {
                if (element == node!!.element) return i
                node = node.next
            }
        }
        return List.ELEMENT_NOT_FOUND
    }

    /**
     * 获取index位置对应的节点对象
     * @param index
     * @return
     */
    private fun node(index: Int): Node<E?>? {
        rangeCheck(index)
        return if (index < size shr 1) {
            var node = first
            for (i in 0 until index) {
                node = node!!.next
            }
            node
        } else {
            var node = last
            for (i in size - 1 downTo index + 1) {
                node = node!!.prev
            }
            node
        }
    }
}