package data.structure.linkedlist

/**
 * 单向循环链表
 * 与普通单链表相比，只是在add（first） remove(last) 有区别
 */
class SingleCircleLinkedList<E> : AbstractList<E>() {
    private var first: Node<E?>? = null

    private class Node<E>(var element: E, var next: Node<E>?) {
    }

    override fun clear() {
        size = 0
        first = null
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
        if (index == 0) {
            val newFirst = Node(element, first)
            // 拿到最后一个节点
            val last = if (size == 0) newFirst else node(size - 1)!!
            //last.next 指向newFirst
            last.next = newFirst
            //newFirst指向first
            first = newFirst
        } else {
            val prev = node(index - 1)
            prev!!.next = Node(element, prev.next)
        }
        size++
    }

    override fun remove(index: Int): E? {
        rangeCheck(index)
        var node = first
        if (index == 0) {
            if (size == 1) {
                first = null
            } else {
                val last = node(size - 1)
                first = first!!.next
                last!!.next = first
            }
        } else {
            val prev = node(index - 1)
            node = prev!!.next
            prev.next = node!!.next
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
        var node = first
        for (i in 0 until index) {
            node = node!!.next
        }
        return node
    }

    override fun toString(): String {
        val string = StringBuilder()
        string.append("size=").append(size).append(", [")
        var node = first
        for (i in 0 until size) {
            if (i != 0) {
                string.append(", ")
            }
            string.append(node)
            node = node!!.next
        }
        string.append("]")
        return string.toString()
    }
}