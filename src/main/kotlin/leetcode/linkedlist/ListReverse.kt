package leetcode.linkedlist

/**
 * 单链表反转
 * 1.递归方式反转
 * 2.遍历方式反转
 */

fun main() {
    var head: Node = Node(1)
    var currentNode = head
    for (i in 2 until 6) {
        var next: Node = Node(i)
        currentNode.next = next
        currentNode = next
    }

    printList(reverseList(head))
//      println(reverseList2(head))
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
 * 递归方式反转
 * 递归实质上就是系统帮你压栈的过程，系统在压栈的时候会保留现场。
我们来看是怎样的一个递归过程：1->2->3->4
程序到达Node newHead = reverse(head.next);时进入递归
我们假设此时递归到了3结点，此时head=3结点，temp=3结点.next(实际上是4结点)
执行Node newHead = reverse(head.next);传入的head.next是4结点，返回的newHead是4结点。
接下来就是弹栈过程了
程序继续执行 temp.next = head就相当于4->3
head.next = null 即把3结点指向4结点的指针断掉。
返回新链表的头结点newHead
 */
fun reverseList(head: Node?): Node? {
    if (head?.next == null) return head
    var tmp: Node? = head.next
    var newHead = reverseList(head.next)
    tmp?.next=head
    head.next=null
    return newHead
}

/**
 * 遍历方式反转
 * 依旧是1->2->3->4
准备两个空结点 pre用来保存先前结点、next用来做临时变量
在头结点node遍历的时候此时为1结点
next = 1结点.next(2结点)
1结点.next=pre(null)
pre = 1结点
node = 2结点
进行下一次循环node=2结点
next = 2结点.next(3结点)
2结点.next=pre(1结点)=>即完成2->1
pre = 2结点
node = 3结点
进行循环
原文链接：https://blog.csdn.net/weixin_40807247/java/article/details/91435275
 */
fun reverseList2(head: Node?): Node? {

    var head = head
    var pre: Node? = null
    var next: Node? = null

    while (head!=null){
        next=head.next
        head.next=pre
        pre=head
        head=next
    }

    return pre
}