package data.structure.arraylist

import data.structure.linkedlist.AbstractList
import data.structure.linkedlist.List

/**
 * 有动态缩容操作
 *
 * @param <E>
</E> */

/**
 * 缩容
 * 1.如果内存使用比较紧张，动态数组有比较多的剩余空间，可以考虑进行缩容操作，比如剩余空间点总容量的一半
 * 时，就进行缩容
 * 2.如果扩容数倍，缩容时机设计不当，有可能会导致复杂度进行震荡
 * 3. 扩容们数与缩容时间的乘积不等于1 就可以避免复杂度震荡问题
 *
 */
class ArrayList<E> @JvmOverloads constructor(capaticy: Int = DEFAULT_CAPACITY) : AbstractList<E>() {
    /**
     * 所有的元素
     */
    private var elements: Array<E?>?

    /**
     * 清除所有元素
     */
    override fun clear() {
        for (i in 0 until size) {
            elements!![i] = null
        }
        size = 0

        // 仅供参考
        if (elements != null && elements!!.size > DEFAULT_CAPACITY) {
            elements = arrayOfNulls<Any>(DEFAULT_CAPACITY) as Array<E?>
        }
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    override fun get(index: Int): E? { // O(1)
        rangeCheck(index)
        return elements!![index]
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    override fun set(index: Int, element: E): E? { // O(1)
        rangeCheck(index)
        val old = elements!![index]
        elements!![index] = element
        return old
    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    override fun add(index: Int, element: E) {
        /*
		 * 最好：O(1)
		 * 最坏：O(n)
		 * 平均：O(n)
		 */
        rangeCheckForAdd(index)
        ensureCapacity(size + 1)
        for (i in size downTo index + 1) {
            elements!![i] = elements!![i - 1]
        }
        elements!![index] = element
        size++
    } // size是数据规模

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    override fun remove(index: Int): E? {
        /*
		 * 最好：O(1)
		 * 最坏：O(n)
		 * 平均：O(n)
		 */
        rangeCheck(index)
        val old = elements!![index]
        for (i in index + 1 until size) {
            elements!![i - 1] = elements!![i]
        }
        elements!![--size] = null
        trim()
        return old
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    override fun indexOf(element: E?): Int {
        if (element == null) {
            for (i in 0 until size) {
                if (elements!![i] == null) return i
            }
        } else {
            for (i in 0 until size) {
                if (element == elements!![i]) return i
            }
        }
        return List.ELEMENT_NOT_FOUND
    }

    /**
     * 保证要有capacity的容量
     * @param capacity
     */
    private fun ensureCapacity(capacity: Int) {
        val oldCapacity = elements!!.size
        if (oldCapacity >= capacity) return

        // 新容量为旧容量的1.5倍
        val newCapacity = oldCapacity + (oldCapacity shr 1)

        // 新容量为旧容量的2倍
        // int newCapacity = oldCapacity << 1;
        val newElements = arrayOfNulls<Any>(newCapacity) as Array<E?>
        for (i in 0 until size) {
            newElements[i] = elements!![i]
        }
        elements = newElements
        println(oldCapacity.toString() + "扩容为" + newCapacity)
    }

    /**
     * 缩容
     * 1.如果内存使用比较紧张，动态数组有比较多的剩余空间，可以考虑进行缩容操作，比如剩余空间点总容量的一半
     * 时，就进行缩容
     * 2.如果扩容数倍，缩容时机设计不当，有可能会导致复杂度进行震荡
     * 3. 扩容们数与缩容时间的乘积不等于1 就可以避免复杂度震荡问题
     *
     */
    private fun trim() {
        // 30
        val oldCapacity = elements!!.size
        // 15
        val newCapacity = oldCapacity shr 1
        if (size > newCapacity || oldCapacity <= DEFAULT_CAPACITY) return

        // 剩余空间还很多
        val newElements = arrayOfNulls<Any>(newCapacity) as Array<E?>
        for (i in 0 until size) {
            newElements[i] = elements!![i]
        }
        elements = newElements
        println(oldCapacity.toString() + "缩容为" + newCapacity)
    }

    override fun toString(): String {
        // size=3, [99, 88, 77]
        val string = StringBuilder()
        string.append("size=").append(size).append(", [")
        for (i in 0 until size) {
            if (i != 0) {
                string.append(", ")
            }
            string.append(elements!![i])

//			if (i != size - 1) {
//				string.append(", ");
//			}
        }
        string.append("]")
        return string.toString()
    }

    companion object {
        private const val DEFAULT_CAPACITY = 10
    }

    init {
        var capaticy = capaticy
        capaticy = if (capaticy < DEFAULT_CAPACITY) DEFAULT_CAPACITY else capaticy
        elements = arrayOfNulls<Any>(capaticy) as Array<E?>
    }
}