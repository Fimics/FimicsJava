package leetcode.linkedlist


fun main() {
    var node1: Node = Node(1)
    var node2: Node = Node(2)
    var node3: Node = Node(3)
    var node4: Node = Node(4)
    var node5: Node = Node(5)

    node1.next=node2
    node2.next=node3
    node3.next=node4
    node4.next=node5
    node5.next=node3



//    printList(node1)
    println(hasCycle(node1))
}


private fun printList(head: Node?) {

    if (head == null) return
    var currentNode = head
    while (currentNode != null) {
        println(currentNode.value)
        currentNode = currentNode.next
    }
}

/**
 * 快慢指针法，
 * 1.为何一定会相遇
 *   每走一步距离就会少1步，
 * 2.fast每次走3步可以吗？
 *    fast为2时，每次缩小一个单位的距离，如果fast为3每次缩小两个单位的距离，可能会错过相遇
 * 判断链表是否有环
 * 时间复杂度O(n)
 */
fun hasCycle(head: Node?):Boolean{

    if (head?.next==null) return false

    var slow = head
    var fast = head.next
    //当fast指针为null 或fast.next为空间结束，表明没有环
    while (fast?.next!=null){

        if (slow==fast) return true

        slow=slow?.next
        fast=fast?.next?.next
    }

    return  false
}