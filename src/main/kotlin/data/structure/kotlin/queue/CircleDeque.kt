package data.structure.kotlin.queue

/**
 * 双向循环队列
 */
class CircleDeque<E> {
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

    /**
     * 从尾部入队
     * @param element
     */
    fun enQueueRear(element: E) {
        ensureCapacity(size + 1)
        elements[index(size)] = element
        size++
    }

    /**
     * 从头部出队
     */
    fun deQueueFront(): E? {
        val frontElement = elements[front]
        elements[front] = null
        front = index(1)
        size--
        return frontElement
    }

    /**
     * 从头部入队
     * @param element
     */
    fun enQueueFront(element: E) {
        ensureCapacity(size + 1)
        front = index(-1)
        elements[front] = element
        size++
    }

    /**
     * 从尾部出队
     */
    fun deQueueRear(): E? {
        val rearIndex = index(size - 1)
        val rear = elements[rearIndex]
        elements[rearIndex] = null
        size--
        return rear
    }

    fun front(): E? {
        return elements[front]
    }

    fun rear(): E? {
        return elements[index(size - 1)]
    }

    override fun toString(): String {
        val string = StringBuilder()
        string.append("capcacity=").append(elements.size)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [")
        for (i in elements.indices) {
            if (i != 0) {
                string.append(", ")
            }
            string.append(elements[i])
        }
        string.append("]")
        return string.toString()
    }

    private fun index(index: Int): Int {
        var index = index
        index += front
        return if (index < 0) {
            index + elements.size
        } else index - if (index >= elements.size) elements.size else 0
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