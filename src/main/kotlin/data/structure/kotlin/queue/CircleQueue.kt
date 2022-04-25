package data.structure.kotlin.queue

/**
 * 循环队列
 */
class CircleQueue<E> {
    private var front = 0
    private var size = 0
    private var elements: Array<E?>
    fun size(): Int {
        return size
    }

    val isEmpty: Boolean
        get() = size == 0

    fun clear() {
        for (i in 0 until size) {
            elements[index(i)] = null
        }
        front = 0
        size = 0
    }

    fun enQueue(element: E) {
        ensureCapacity(size + 1)
        elements[index(size)] = element
        size++
    }

    fun deQueue(): E? {
        val frontElement = elements[front]
        elements[front] = null
        front = index(1)
        size--
        return frontElement
    }

    fun front(): E? {
        return elements[front]
    }


    private fun index(index: Int): Int {
        var index = index
        index += front
        return index - if (index >= elements.size) elements.size else 0
    }

    /**
     * 保证要有capacity的容量
     * @param capacity
     */
    private fun ensureCapacity(capacity: Int) {
        val oldCapacity = elements.size
        if (oldCapacity >= capacity) return

        // 新容量为旧容量的1.5倍
        val newCapacity = oldCapacity + (oldCapacity shr 1)
        val newElements = arrayOfNulls<Any>(newCapacity) as Array<E?>
        for (i in 0 until size) {
            newElements[i] = elements[index(i)]
        }
        elements = newElements

        // 重置front
        front = 0
    }

    companion object {
        private const val DEFAULT_CAPACITY = 10
    }

    init {
        elements = arrayOfNulls<Any>(DEFAULT_CAPACITY) as Array<E?>
    }
}