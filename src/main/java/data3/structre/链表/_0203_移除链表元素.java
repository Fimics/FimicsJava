package data3.structre.链表;

import data.structure.linkedlist.List;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 
 * @author MJ
 *
 */
public class _0203_移除链表元素 {
//	public ListNode removeElements(ListNode head, int val) {
//		if (head == null) return null;
//		
//		// 新链表的头结点
//		ListNode newHead = null;
//		// 新链表的尾结点
//		ListNode newTail = null;
//		
//		while (head != null) {
//			if (head.val != val) {
//				// 将head拼接到newTail的后面
//				if (newTail == null) {
//					newHead = head;
//					newTail = head;
//				} else {
//					newTail.next = head;
//					newTail = head;
//				}
//			}
//			head = head.next;
//		}
//		if (newTail == null) {
//			return null;
//		} else {
//			// 尾结点的next要清空
//			newTail.next = null;
//		}
//		return newHead;
//	}
	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) return null;
		// 新链表的头结点
		ListNode newHead = new ListNode(0);
		// 新链表的最后一个节点
		ListNode newTail = newHead;
		while (head != null) {
			if (head.val != val) {
				//把head 拼结到新链表尾部
				newTail.next = head;
				newTail = head;
			}
			head = head.next;
		}
		//尾节点的next要清空，因为最后可是是要删除的元素不能删除
		newTail.next = null;
		return newHead.next;
	}

	public static void main(String[] args) {
		ListNode l0 = new ListNode(2);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(6);
		ListNode l3 = new ListNode(4);

		l0.next=l1;
		l1.next=l2;
		l2.next=l3;

		System.out.println(l0);

		removeElements(l0,6);
		System.out.println(l0);
	}
}
