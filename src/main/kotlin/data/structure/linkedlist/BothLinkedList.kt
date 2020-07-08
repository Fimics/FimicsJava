package data.structure.linkedlist

/**
 * 双向链表
 * 虚拟头结点与虚拟尾结点，增加虚拟结点可以统一处理结点逻辑
 */

class BothLinkedList<E> : AbstractList<E>() {
    private var first: Node<E?>? = null
    private var last: Node<E?>? = null

    private class Node<E>(var prev: Node<E>?, var element: E, var next: Node<E>?) {
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
            last = Node(oldLast, element, null)
            if (oldLast == null) { // 这是链表添加的第一个元素
                first = last
            } else {
                oldLast.next = last
            }
        } else {
            val next = node(index)
            val prev = next!!.prev
            val node = Node(prev, element, next)
            next.prev = node
            if (prev == null) { // index == 0
                first = node
            } else {
                prev.next = node
            }
        }
        size++
    }

    override fun remove(index: Int): E? {
        rangeCheck(index)
        val node = node(index)
        val prev = node!!.prev
        val next = node.next
        if (prev == null) { // index == 0
            first = next
        } else {
            prev.next = next
        }
        if (next == null) { // index == size - 1
            last = prev
        } else {
            next.prev = prev
        }
        size--
        return node.element
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
        return List.Companion.ELEMENT_NOT_FOUND
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