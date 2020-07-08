package data.structure.linkedlist

abstract class AbstractList<E> : List<E> {
    /**
     * 元素的数量
     */
    protected var size = 0

    /**
     * 元素的数量
     * @return
     */
    override fun size(): Int {
        return size
    }

    /**
     * 是否为空
     * @return
     */
    override val isEmpty: Boolean
        get() = size == 0

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    override fun contains(element: E): Boolean {
        return indexOf(element) != List.Companion.ELEMENT_NOT_FOUND
    }

    /**
     * 添加元素到尾部
     * @param element
     */
    override fun add(element: E) {
        add(size, element)
    }

    protected fun outOfBounds(index: Int) {
        throw IndexOutOfBoundsException("Index:$index, Size:$size")
    }

    protected fun rangeCheck(index: Int) {
        if (index < 0 || index >= size) {
            outOfBounds(index)
        }
    }

    protected fun rangeCheckForAdd(index: Int) {
        if (index < 0 || index > size) {
            outOfBounds(index)
        }
    }
}