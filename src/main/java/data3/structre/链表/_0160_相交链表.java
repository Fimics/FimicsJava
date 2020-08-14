package data3.structre.链表;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 
 * @author MJ
 *
 */
public class _0160_相交链表 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		//让两个指针把两条链表都走一遍  A接到B后，B接到A后，这样链表的长度就相等了
		ListNode curA = headA, curB = headB;
		while (curA != curB) {
			//A接到B后，B接到A后，这样链表的长度就相等了
			curA = (curA == null) ? headB : curA.next;
			curB = (curB == null) ? headA : curB.next;
			// 这段代码在两个链表不相交的时候会死循环? 不会死循环，都==null也会退出
			// curA = (curA.next == null) ? headB : curA.next;
			// curB = (curB.next == null) ? headA : curB.next;
		}
		return curA;
	}
}
