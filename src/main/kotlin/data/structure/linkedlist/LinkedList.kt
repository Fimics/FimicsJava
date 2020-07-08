package data.structure.linkedlist

/**
 * 增加一个虚拟头结点
 * @author MJ Lee
 *
 * @param <E>
</E> */
class LinkedList<E> : AbstractList<E>() {
    private var first: Node<E?>?

    private class Node<E>(var element: E, var next: Node<E>?)

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
        val prev = if (index == 0) first else node(index - 1)
        prev!!.next = Node(element, prev.next)
        size++
    }

    override fun remove(index: Int): E? {
        rangeCheck(index)
        val prev = if (index == 0) first else node(index - 1)
        val node = prev!!.next
        prev.next = node!!.next
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
        return List.ELEMENT_NOT_FOUND
    }

    /**
     * 获取index位置对应的节点对象
     * @param index
     * @return
     */
    private fun node(index: Int): Node<E?>? {
        rangeCheck(index)
        var node = first!!.next
        for (i in 0 until index) {
            node = node!!.next
        }
        return node
    }

    override fun toString(): String {
        val string = StringBuilder()
        string.append("size=").append(size).append(", [")
        var node = first!!.next
        for (i in 0 until size) {
            if (i != 0) {
                string.append(", ")
            }
            string.append(node!!.element)
            node = node.next
        }
        string.append("]")

//		Node<E> node1 = first;
//		while (node1 != null) {
//			
//			
//			node1 = node1.next;
//		}
        return string.toString()
    }

    init {
        first = Node(null, null)
    }
}