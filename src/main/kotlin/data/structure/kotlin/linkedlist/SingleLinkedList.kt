package data.structure.kotlin.linkedlist

/**
 * 普通单向链表
 */
class SingleLinkedList<E> : AbstractList<E>() {
    private var first: Node<E?>? = null

    private class Node<E>(var element: E, var next: Node<E>?)

    override fun clear() {
        size = 0
        first = null
    }

    override fun get(index: Int): E? {
        /*
		 * 最好：O(1)
		 * 最坏：O(n)
		 * 平均：O(n)
		 */
        return node(index)!!.element
    }

    override fun set(index: Int, element: E): E? {
        /*
		 * 最好：O(1)
		 * 最坏：O(n)
		 * 平均：O(n)
		 */
        val node = node(index)
        val old = node!!.element
        node.element = element
        return old
    }

    override fun add(index: Int, element: E) {
        /*
		 * 最好：O(1)
		 * 最坏：O(n)
		 * 平均：O(n)
		 */
        rangeCheckForAdd(index)
        if (index == 0) {
            first = Node(element, first)
        } else {
            val prev = node(index - 1)
            prev!!.next = Node(element, prev.next)
        }
        size++
    }

    override fun remove(index: Int): E? {
        /*
		 * 最好：O(1)
		 * 最坏：O(n)
		 * 平均：O(n)
		 */
        rangeCheck(index)
        var node = first
        if (index == 0) {
            first = first!!.next
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
}